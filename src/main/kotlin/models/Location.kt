package models

data class Location(
    val coordinates: Coordinates,
    val country: String,
    val country_code: String,
    val id: Int,
    val latest: LatestData,
    val province: String
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)