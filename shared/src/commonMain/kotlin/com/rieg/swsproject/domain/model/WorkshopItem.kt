package com.rieg.swsproject.domain.model

data class WorkshopItem(
    val title: String,
    val previewUrl: String,
    val views: Int,
    val likes: Int,
    val dislikes: Int,
    val favorites: Int,
    val subscriptions: Int,
    val appName: String
)
