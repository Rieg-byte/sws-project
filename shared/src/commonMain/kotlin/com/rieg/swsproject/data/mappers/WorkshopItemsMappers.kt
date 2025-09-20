package com.rieg.swsproject.data.mappers

import com.rieg.swsproject.data.model.WorkshopItemResponse
import com.rieg.swsproject.data.model.WorkshopItemsResponse
import com.rieg.swsproject.domain.model.WorkshopItem
import com.rieg.swsproject.domain.model.WorkshopItems

fun WorkshopItemsResponse.toWorkshopItems(): WorkshopItems {
    return WorkshopItems(
        total = total,
        workshopItems = publishedFileDetails.map { it.toWorkshopItem() }
    )
}

fun WorkshopItemResponse.toWorkshopItem(): WorkshopItem {
    return WorkshopItem(
        title = title,
        previewUrl = previewUrl,
        views = views,
        likes = voteData.votesUp,
        dislikes = voteData.votesDown,
        favorites = favorited,
        subscriptions = subscriptions,
        appName = appName
    )
}