package com.martamazurkozlowska.superapp.app.album.mapper

import com.martamazurkozlowska.superapp.domain.album.PhotoDomainModel
import com.martamazurkozlowska.superapp.ui.view.album.photolist.PhotoUiModel

fun PhotoDomainModel.toUiModel() = PhotoUiModel(
    albumId = albumId,
    id = id,
    title = title,
    url = url,
    thumbnailUrl = thumbnailUrl,
)