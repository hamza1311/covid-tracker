import { LatestData } from "./models";

export module Client {

    const API_URL = 'https://coronavirus-tracker-api.herokuapp.com/v2/latest';

    /**
     * Returns a {@link Promise} of {@link LatestData}
     *
     * @author Benjozork
     */
    export function getLatestData(): Promise<LatestData> {
        const request = new Request(API_URL, {method: 'GET'});

        return fetch(request)
            .then(response => response.json())
            .then(json => json['latest']);
    }

}
