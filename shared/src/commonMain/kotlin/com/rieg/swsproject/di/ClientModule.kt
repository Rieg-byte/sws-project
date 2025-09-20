package com.rieg.swsproject.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json
import org.koin.dsl.module

const val STEAM_API = "https://api.steampowered.com/"

val clientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                Json {
                    ignoreUnknownKeys = true
                }
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
                filter { request ->
                    request.url.host.contains("ktor.io")
                }
                sanitizeHeader { header -> header == HttpHeaders.Authorization }
            }
            install(DefaultRequest)
            defaultRequest {
                url(STEAM_API)
            }
        }
    }
}