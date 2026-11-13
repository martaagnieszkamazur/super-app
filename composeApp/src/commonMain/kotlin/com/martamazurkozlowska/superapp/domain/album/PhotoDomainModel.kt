package com.martamazurkozlowska.superapp.domain.album

data class PhotoDomainModel(
    val albumId: Long,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)