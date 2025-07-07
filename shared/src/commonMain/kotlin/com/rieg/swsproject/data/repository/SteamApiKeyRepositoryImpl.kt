package com.rieg.swsproject.data.repository

import com.rieg.swsproject.domain.model.SteamApiKey
import com.rieg.swsproject.domain.repository.SteamApiKeyRepository
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

const val WEB_API = "webApi"
const val DEFAULT_VALUE_WEB_API = ""

class SteamApiKeyRepositoryImpl(
    private val settings: Settings
) : SteamApiKeyRepository {
    override suspend fun saveApiKey(apiKey: String) {
        settings.putString(WEB_API, apiKey)
    }

    override suspend fun removeApiKey() {
        settings.remove(WEB_API)
    }

    override suspend fun getApiKey(): SteamApiKey {
        val apiKey =settings.getString(
            key = WEB_API,
            defaultValue = DEFAULT_VALUE_WEB_API
        )
        return SteamApiKey(apiKey)
    }
}