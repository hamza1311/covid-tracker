@file:Suppress("PropertyName", "SpellCheckingInspection")

val ktor_version = "1.3.1"
val kotlinx_html_version = "0.7.1"

plugins {
    id("org.jetbrains.kotlin.js") version "1.3.70"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:$kotlinx_html_version")
}

kotlin.target.browser {

}