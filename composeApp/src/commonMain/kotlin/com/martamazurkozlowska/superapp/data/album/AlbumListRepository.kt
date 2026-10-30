package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.data.network.AlbumApiService

class AlbumListRepository(
    private val apiService: AlbumApiService,
) {

    suspend fun getAlbumList(): List<AlbumApiModel> =
        try {
            apiService.getAlbumList()
        } catch (exception: Exception) {
            exception.printStackTrace()
            emptyList()
        }
}