package com.rieg.swsproject.data.repository

import com.rieg.swsproject.data.mappers.toWorkshopItems
import com.rieg.swsproject.data.remote.SteamNetworkDataSource
import com.rieg.swsproject.domain.model.WorkshopItem
import com.rieg.swsproject.domain.repository.WorkshopItemRepository

class WorkshopItemRepositoryImpl(
    private val steamNetworkDataSource: SteamNetworkDataSource
) : WorkshopItemRepository {
    override suspend fun getWorkshopItems(
        steamId: String,
        page: Int,
        count: Int
    ): List<WorkshopItem> {
        val workshopItems = steamNetworkDataSource.getWorkshopItems(steamId, page, count).toWorkshopItems().workshopItems
        return workshopItems
    }
}