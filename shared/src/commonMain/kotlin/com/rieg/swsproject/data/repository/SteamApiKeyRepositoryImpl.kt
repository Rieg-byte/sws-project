package com.rieg.swsproject.data.repository

import com.rieg.swsproject.data.datastore.DataStore
import com.rieg.swsproject.domain.model.SteamApiKey
import com.rieg.swsproject.domain.repository.SteamApiKeyRepository


class SteamApiKeyRepositoryImpl(
    private val dataStore: DataStore
) : SteamApiKeyRepository {
    override suspend fun saveApiKey(apiKey: String) {
        dataStore.saveApiKey(apiKey)
    }

    override suspend fun removeApiKey() {
        dataStore.removeApiKey()
    }

    override suspend fun getApiKey(): SteamApiKey {
        val apiKey = dataStore.getApiKey()
        return SteamApiKey(apiKey)
    }
}