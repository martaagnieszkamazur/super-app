package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.domain.album.PhotoDomainModel
import com.martamazurkozlowska.superapp.ui.view.album.photolist.PhotoUiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoApiModel(
    @SerialName("albumId")
    val albumId: Long,

    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("url")
    val url: String,

    @SerialName("thumbnailUrl")
    val thumbnailUrl: String,
) {
}

fun PhotoApiModel.toDomainModel() = PhotoDomainModel(
    albumId = albumId,
    id = id,
    title = title,
    url = url,
    thumbnailUrl = thumbnailUrl,
)