package com.rieg.swsproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WorkshopItemResponse(
    @SerialName("publishedfileid")
    val publishedFileId: String,
    @SerialName("preview_url")
    val previewUrl: String,
    val title: String,
    @SerialName("app_name")
    val appName: String,
    val subscriptions: Int,
    val favorited: Int,
    val views: Int,
    @SerialName("vote_data")
    val voteData: VoteDataResponse
)

@Serializable
data class VoteDataResponse(
    @SerialName("votes_up")
    val votesUp: Int,
    @SerialName("votes_down")
    val votesDown: Int
)