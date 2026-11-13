package com.martamazurkozlowska.superapp.ui.view.album.photolist

import kotlinx.serialization.Serializable

@Serializable
data class PhotoUiModel(
    val albumId: Long,
    val id:Int,
    val title:String,
    val url: String,
    val thumbnailUrl: String
) {
}