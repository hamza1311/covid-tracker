import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onSelectFunction
import kotlinx.html.js.option
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.get
import utils.Presenter
import utils.countries
import kotlin.browser.document

suspend fun main() {
    val latestData = CoronaChanTrackerWrapper.getLatest()
    createDivInRoot {
        id = "container-data"
        createCasesDiv("active", "virus", "Active Cases", latestData.confirmed.toString())
        createCasesDiv("recoveries", "smile", "Recoveries", latestData.recovered.toString())
        createCasesDiv("deaths", "death", "Deaths", latestData.deaths.toString())
    }

    createDivInRoot {
        id = "container-location-switcher"
        div {
            id = "country-switcher"
            label { id = "label-country" }
            select {
                id = "select-country"
                name = "select-country"
                countries.forEach {
                    option { +"${it.key} - ${it.value}" }
                }
                onChangeFunction = {
                    // This is probably a horrible way to do this so
                    // TODO: Try and find a better way
                    val text = (document.querySelector("#select-country") as HTMLSelectElement)
                            .selectedOptions[0]!!.textContent

                    GlobalScope.launch {
                        if (text!!.startsWith("XX"))
                            Presenter.presentForGlobal()
                        else
                            Presenter.presentForLocal(text.split("-")[0])
                    }
                }
            }
        }
    }

    createDivInRoot {
        id = "container-update"
        span {
            id = "label-update"
            +"Last Update: "
        }
        span {
            id = "data-update"
            GlobalScope.launch {
                val lastUpdate = CoronaChanTrackerWrapper.getLastUpdate()
                document.querySelector("#data-update")?.textContent = // Yeah, I'm getting the same element but idk a better way
                        "${lastUpdate.toLocaleDateString()}, ${lastUpdate.toLocaleTimeString()}"
            }
        }
    }

    createDivInRoot {
        id = "container-footer"
        span {
            id = "footer-api-link"
            span {
                id = "label-api-link"
                +"Data Source: "
            }
            a {
                href = "https://github.com/ExpDev07/coronavirus-tracker-api"
                +"https://github.com/ExpDev07/coronavirus-tracker-api"
            }
        }

        span {
            id = "footer-info"
            +"Version 1.5 | 2020 Benjamin Dupont & Muhammad Hamza | "
            a {
                href = "https://github.com/hamza1311/covid-tracker"
                +"https://github.com/hamza1311/covid-tracker"
            }
        }

        span {
            span { +"Icons made by " }
            a {
                href = "https://www.flaticon.com/authors/freepik"
                title = "Freepik"
                +"Freepik"
            }
            span { +" from " }
            a {
                href = "https://www.flaticon.com/"
                title = "Flaticon"
                +"www.flaticon.com"
            }
        }
    }
}

fun createDivInRoot(classes: String? = null, block: DIV.() -> Unit) {
    document.getElementById("root")!!.appendChild(document.create.div(classes = classes, block = block))
}

fun DIV.createCasesDiv(divId: String, assetName: String, text: String, data: String) {
    div {
        id = divId
        img {
            src = "assets/$assetName.svg"
            alt = "Cases"
        }
        div {
            span {
                id = "label-$divId"
                +text
            }
            span {
                id = "data-${divId}"
                +data
            }
        }
    }
}
