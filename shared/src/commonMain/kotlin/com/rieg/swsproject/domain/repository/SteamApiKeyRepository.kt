package com.rieg.swsproject.domain.repository

import com.rieg.swsproject.domain.model.SteamApiKey

interface SteamApiKeyRepository {

    suspend fun saveApiKey(apiKey: String)

    suspend fun removeApiKey()

    suspend fun getApiKey(): SteamApiKey

}