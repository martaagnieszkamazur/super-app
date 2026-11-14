package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.domain.album.AlbumDomainModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumApiModel(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,
)

fun AlbumApiModel.toDomainModel() = AlbumDomainModel(
    id = id,
    title = title
)
