package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.domain.album.AlbumDomainModel
import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumUiModel

fun AlbumDomainModel.toUiModel() = AlbumUiModel(
    id = id,
    title = title,
)