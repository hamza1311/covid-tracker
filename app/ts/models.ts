/**
 * Data model for the /latest data
 *
 * @property confirmed the number of currently active cases of COVID-19
 * @property recovered the number of people who have recovered from COVID-19
 * @property deaths    the number of people to have died from COVID-19
 */
export interface LatestData {
    confirmed: number,
    recovered: number,
    deaths: number
}
