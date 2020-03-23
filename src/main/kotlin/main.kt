import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.dom.create
import kotlinx.html.js.option
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.get
import utils.Presenter
import utils.countries
import kotlin.browser.document

suspend fun main() {
    Presenter.presentForGlobal()

    val lastUpdate = CoronaChanTrackerWrapper.getLastUpdate()
    document.querySelector("#data-update")?.textContent =
        "${lastUpdate.toLocaleDateString()}, ${lastUpdate.toLocaleTimeString()}"

    val select = document.querySelector("#select-country") as HTMLSelectElement
    countries.forEach {
        select.appendChild(document.create.option {
            text("${it.key} - ${it.value}")
        })
    }

    select.addEventListener("change", {
        val text = select.selectedOptions[0]?.textContent
        if (text == null) {
            console.log("NOOOOOOOOOOO")
        }

        if (text!!.startsWith("XX")) {
            // I probably shouldn't be using it but I'm not aware of any better way to do it that
            GlobalScope.launch { Presenter.presentForGlobal() }
        } else {
            val code = text.split("-")[0].trim()
            // Again, I probably shouldn't be using it but its the only way
            GlobalScope.launch { Presenter.presentForLocal(code) }
        }
    })
}
