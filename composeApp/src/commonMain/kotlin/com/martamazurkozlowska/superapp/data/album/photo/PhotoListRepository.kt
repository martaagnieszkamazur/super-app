package com.martamazurkozlowska.superapp.data.album.photo

import com.martamazurkozlowska.superapp.data.network.AlbumApiService
import com.martamazurkozlowska.superapp.domain.album.PhotoDomainModel

class PhotoListRepository(
    private val apiService: AlbumApiService,
) {
    suspend fun getPhotoList(albumId: Long): List<PhotoDomainModel> {
        return apiService.getPhotoList(albumId).map { it.toDomainModel() }
    }
}