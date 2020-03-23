package models

data class LatestData(
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int
)

data class LatestRespPayload(val latest: LatestData)