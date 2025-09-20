package com.rieg.swsproject.data.datastore

import com.russhwolf.settings.Settings


class DataStoreImpl(
    private val settings: Settings
) : DataStore {
    override fun saveApiKey(apiKey: String) {
        settings.putString(WEB_API, apiKey)
    }

    override fun removeApiKey() {
        settings.remove(WEB_API)
    }

    override fun getApiKey(): String {
        val apiKey = settings.getString(
            key = WEB_API,
            defaultValue = DEFAULT_VALUE_WEB_API
        )
        return apiKey
    }

    private companion object {
        const val WEB_API = "webApi"
        const val DEFAULT_VALUE_WEB_API = ""
    }
}