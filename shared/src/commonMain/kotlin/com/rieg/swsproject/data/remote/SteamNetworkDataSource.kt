package com.rieg.swsproject.data.remote

import com.rieg.swsproject.data.model.WorkshopItemsResponse

interface SteamNetworkDataSource {
    suspend fun getWorkshopItems(steamId: String, page: Int, count: Int): WorkshopItemsResponse
}