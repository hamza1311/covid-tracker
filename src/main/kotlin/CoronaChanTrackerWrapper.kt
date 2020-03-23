import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import models.LatestData
import models.LatestRespPayload
import models.Location
import kotlin.js.Date

object CoronaChanTrackerWrapper {
    private val client = HttpClient()
    private const val API_URL = "https://coronavirus-tracker-api.herokuapp.com/v2"

    private suspend fun <T> request(url: String): T {
        val resp = client.get<HttpResponse>(url)
        return JSON.parse(resp.readText())
    }

    suspend fun getLatest(): LatestData {
        return request<LatestRespPayload>("$API_URL/latest").latest
    }

    suspend fun getForLocation(countryCode: String): Location {
        return request<Location>("$API_URL/locations?country_code=$countryCode")
    }

    suspend fun getLastUpdate(): Date {
        val url = "https://api.github.com/repos/CSSEGISandData/COVID-19/commits/master"
        val resp = request<dynamic>(url)
        return Date((resp["commit"]["author"]["date"]).toString())
    }
}