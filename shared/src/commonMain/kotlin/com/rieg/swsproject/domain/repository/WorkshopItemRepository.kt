package com.rieg.swsproject.domain.repository

import com.rieg.swsproject.domain.model.WorkshopItem

interface WorkshopItemRepository {
    suspend fun getWorkshopItems(steamId: String, page: Int, count: Int): List<WorkshopItem>
}