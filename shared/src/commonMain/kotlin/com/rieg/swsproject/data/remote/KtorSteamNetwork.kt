package com.rieg.swsproject.data.remote

import com.rieg.swsproject.data.datastore.DataStore
import com.rieg.swsproject.data.model.NetworkResponse
import com.rieg.swsproject.data.model.WorkshopItemsResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*

class KtorSteamNetwork(
    private val httpClient: HttpClient,
    private val dataStore: DataStore
) : SteamNetworkDataSource {
    override suspend fun getWorkshopItems(steamId: String, page: Int, count: Int): WorkshopItemsResponse {
        val networkResponse: NetworkResponse<WorkshopItemsResponse> = httpClient
            .get("IPublishedFileService/GetUserFiles/v1") {
                url {
                    parameters.append("key", dataStore.getApiKey())
                    parameters.append("steamid", steamId)
                    parameters.append("page", "$page")
                    parameters.append("count", "$page")
                }
            }.body()
        return networkResponse.response
    }
}