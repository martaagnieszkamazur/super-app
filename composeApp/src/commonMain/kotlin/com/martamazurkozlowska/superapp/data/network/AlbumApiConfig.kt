package com.martamazurkozlowska.superapp.data.network

object AlbumApiConfig {

    const val BASE_URL = "https://jsonplaceholder.typicode.com"

    object Endpoints {
        fun getAlbums() = "/albums"
        fun getPhotos(albumId: Int) = "/albums/$albumId/photos"
    }
}
