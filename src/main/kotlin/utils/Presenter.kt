package utils

import models.LatestData
import org.w3c.dom.HTMLSpanElement
import kotlin.browser.document

object Presenter {
    private fun getSpanElement(selector: String) = document.querySelector(selector) as HTMLSpanElement

    private fun present(data: LatestData) {
        getSpanElement("#data-active").textContent = data.confirmed.toString()
        getSpanElement("#data-recoveries").textContent = data.recovered.toString()
        getSpanElement("#data-deaths").textContent = data.deaths.toString()
    }

    suspend fun presentForGlobal() {
        val data = CoronaChanTrackerWrapper.getLatest()
        present(data)
    }

    suspend fun presentForLocal(countryCode: String) {
        val data = CoronaChanTrackerWrapper.getForLocation(countryCode)
        present(data.latest)
    }
}