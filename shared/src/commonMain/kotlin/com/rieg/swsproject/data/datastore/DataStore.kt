package com.rieg.swsproject.data.datastore

interface DataStore {
    fun saveApiKey(apiKey: String)

    fun removeApiKey()

    fun getApiKey(): String
}