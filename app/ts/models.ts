/**
 * Data model for the main data
 *
 * @property confirmed the number of currently active cases of COVID-19
 * @property recovered the number of people who have recovered from COVID-19
 * @property deaths    the number of people to have died from COVID-19
 *
 * @author Benjozork
 */
export interface LatestData {
    confirmed: number,
    recovered: number,
    deaths: number
}

/**
 * Data model for the /locations data
 *
 * @property coordinates  the coordinates of the location
 * @property country      the country name of the location
 * @property country_code the country code of the location
 * @property id           the location id
 * @property latest       the latest data for the location
 * @property province     if this is a province, this will have an independent name
 *
 * @author Benjozork
 */
export interface Location {
    coordinates: Coordinates;
    country: string;
    country_code: string;
    id: number;
    latest: LatestData;
    province: string;
}

/**
 * Data model for location coordinates. Self-explanatory.
 *
 * @author Benjozork
 */
export interface Coordinates {
    latitude: string;
    longitude: string;
}
