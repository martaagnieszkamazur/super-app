package com.martamazurkozlowska.superapp.data.album

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumApiModel(

    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,
)
