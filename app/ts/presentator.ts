import { Client } from "./client";
import countries from '../assets/countries.json';

const numberFormat = Intl.NumberFormat('en');

/**
 * Sets up the main presentation for the entire world
 */
export function presentForGlobal() {
    Client.getLatestData().then(latestData => {
        document.querySelector('#data-active').textContent = numberFormat.format(latestData.confirmed);
        document.querySelector('#data-recoveries').textContent = numberFormat.format(latestData.recovered);
        document.querySelector('#data-deaths').textContent = numberFormat.format(latestData.deaths);
    });
    Client.getLastUpdate().then(update => {
       document.querySelector('#data-update').textContent = `${update.toLocaleDateString()}, ${update.toLocaleTimeString()}`;
    });
}

/**
 * Sets up the main presentation for a specific location
 */
export function presentForLocation(countryCode: string) {
    Client.getLocation(countryCode).then(data => {
        document.querySelector('#data-active').textContent = numberFormat.format(data.latest.confirmed);
        document.querySelector('#data-recoveries').textContent = numberFormat.format(data.latest.recovered);
        document.querySelector('#data-deaths').textContent = numberFormat.format(data.latest.deaths);
    })
}

/**
 * Sets up the country selection code
 */
export async function setupLocationChoices() {
    const select = document.querySelector('#select-country') as HTMLSelectElement

    const countryObjects = countries as object[]

    countryObjects.forEach(it => {
       const node = document.createElement('option')
       node.innerText = `${it['code']} - ${it['name']}`

        select.appendChild(node);
    });

    select.addEventListener('change', (event) => {
        const text = select.selectedOptions[0].text; // Hacky, I know !
        if (text.match(/XX/)) {
            presentForGlobal();
        } else presentForLocation(text.split(' - ')[0]);
    });
}
