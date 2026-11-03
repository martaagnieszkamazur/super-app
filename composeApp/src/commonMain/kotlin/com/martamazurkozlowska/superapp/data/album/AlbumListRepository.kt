package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.data.network.AlbumApiService
import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumUiModel

class AlbumListRepository(
    private val apiService: AlbumApiService,
) {

    suspend fun getAlbumList(): List<AlbumUiModel> =
        try {
            apiService.getAlbumList().map { it.toUiModel() }
        } catch (exception: Exception) {
            exception.printStackTrace()
            emptyList()
        }
}