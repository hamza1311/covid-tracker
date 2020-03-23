import org.w3c.dom.HTMLSpanElement
import kotlin.browser.document

fun getSpanElement(selector: String) = document.querySelector(selector) as HTMLSpanElement

suspend fun main() {
    val data = CoronaChanTrackerWrapper.getLatest()
    getSpanElement("#data-active").textContent = data.confirmed.toString()
    getSpanElement("#data-recoveries").textContent = data.recovered.toString()
    getSpanElement("#data-deaths").textContent = data.deaths.toString()
}