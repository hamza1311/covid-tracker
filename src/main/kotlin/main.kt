import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.HTMLSpanElement
import utils.countries
import kotlin.browser.document

fun getSpanElement(selector: String) = document.querySelector(selector) as HTMLSpanElement

suspend fun main() {
    val data = CoronaChanTrackerWrapper.getLatest()
    getSpanElement("#data-active").textContent = data.confirmed.toString()
    getSpanElement("#data-recoveries").textContent = data.recovered.toString()
    getSpanElement("#data-deaths").textContent = data.deaths.toString()
    val pk = CoronaChanTrackerWrapper.getForLocation("PK")
    console.log(pk)

    val select = document.querySelector("#select-country") as HTMLSelectElement

    countries.forEach {
        val node = document.createElement("option") as HTMLOptionElement
        node.innerText = "${it.key} - ${it.value}"
        select.appendChild(node)
    }
}