package com.martamazurkozlowska.superapp.data.album

import com.martamazurkozlowska.superapp.data.network.AlbumApiService
import com.martamazurkozlowska.superapp.domain.album.AlbumDomainModel

class AlbumListRepository(
    private val apiService: AlbumApiService,
) {

    suspend fun getAlbumList(): List<AlbumDomainModel> {
        return apiService.getAlbumList().map { it.toDomainModel() }
    }
}