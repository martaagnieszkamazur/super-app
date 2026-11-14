package com.martamazurkozlowska.superapp.ui.view.album.albumlist

import kotlinx.serialization.Serializable

@Serializable
data class AlbumUiModel(
    val id: Long,
    val title: String,
) {
}