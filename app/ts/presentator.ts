import { Client } from "./client";

const numberFormat = Intl.NumberFormat('en');

/**
 * Sets up the main presentation
 */
export function setupPresentation() {
    Client.getLatestData().then(latestData => {
        document.querySelector('#data-active').textContent = numberFormat.format(latestData.confirmed);
        document.querySelector('#data-recoveries').textContent = numberFormat.format(latestData.recovered);
        document.querySelector('#data-deaths').textContent = numberFormat.format(latestData.deaths);
    });
    Client.getLastUpdate().then(update => {
       document.querySelector('#data-update').textContent = `${update.toLocaleDateString()}, ${update.toLocaleTimeString()}`;
    });
}
