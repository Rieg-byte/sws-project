plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    jvm()
    js(IR) {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.logback.classic)
                implementation(libs.koin.core)
            }
        }

        val commonTest by getting {
            dependencies {

            }
        }

        val jsMain by getting {
            dependencies {

            }
        }
    }
}