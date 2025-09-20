package com.rieg.swsproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkshopItemsResponse(
    val total: Int,
    @SerialName("startindex")
    val startIndex: Int,
    @SerialName("publishedfiledetails")
    val publishedFileDetails: List<WorkshopItemResponse>
)