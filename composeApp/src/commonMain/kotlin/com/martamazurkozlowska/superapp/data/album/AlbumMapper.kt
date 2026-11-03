package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumUiModel

fun AlbumApiModel.toUiModel() =
    AlbumUiModel(
        id = id,
        title = title,
    )

fun AlbumUiModel.toApiModel() =
    AlbumApiModel(
        id = id,
        title = title,
    )