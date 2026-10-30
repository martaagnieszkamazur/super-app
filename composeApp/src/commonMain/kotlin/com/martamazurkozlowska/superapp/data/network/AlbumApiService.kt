package com.martamazurkozlowska.superapp.data.network

import com.martamazurkozlowska.superapp.data.album.AlbumApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class AlbumApiService {

    private val httpClient: HttpClient = createHttpClient()

    suspend fun getAlbumList(): List<AlbumApiModel> =
        httpClient.get(AlbumApiConfig.Endpoints.getAlbums()).body<List<AlbumApiModel>>()
}

private fun createHttpClient(): HttpClient = HttpClient {
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }

    defaultRequest {
        url(AlbumApiConfig.BASE_URL)
        contentType(ContentType.Application.Json)
    }
}