import { LatestData, Location } from "./models";

export module Client {

    const API_URL = 'https://coronavirus-tracker-api.herokuapp.com/v2';

    /**
     * Returns a {@link Promise} of {@link LatestData}
     *
     * @author Benjozork
     */
    export function getLatestData(): Promise<LatestData> {
        const request = new Request(`${API_URL}/latest`, { method: 'GET', cache: "force-cache" });

        return fetch(request)
            .then(response => response.json())
            .then(json => json['latest']);
    }

    export function getLastUpdate(): Promise<Date> {
        const request = new Request('https://api.github.com/repos/CSSEGISandData/COVID-19/commits/master')

        return fetch(request)
            .then(response => response.json())
            .then(json => new Date(json['commit']['author']['date'] as string))
    }

    /**
     * Returns a {@link Promise} of {@link LatestData} for the location with the given country code
     *
     * @author Benjozork
     */
    export function getLocation(countryCode: string): Promise<Location[]> {
        const request = new Request(`${API_URL}/locations?country_code=${countryCode}`, { method: 'GET' });

        return fetch(request)
            .then(response => response.json())
            .then(json => json['locations'])
    }

}
