plugins {
    id("org.jetbrains.kotlin.js") version "1.3.70"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    val ktor_version = "1.3.1"
    implementation("io.ktor:ktor-client-js:$ktor_version")
}

kotlin.target.browser {

}