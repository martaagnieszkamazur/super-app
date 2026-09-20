package com.martamazurkozlowska.superapp.data.tasks

import com.martamazurkozlowska.superapp.data.network.ApiConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TasksRepository(
    private val httpClient: HttpClient,
) {

    suspend fun getTasks(): List<TaskUiModel> =
        try {
            httpClient.get(ApiConfig.Endpoints.TASKS)
                .body<List<TaskApiModel>>()
                .map { it.toUiModel() }
        } catch (exception: Exception) {
            exception.printStackTrace()
            emptyList()
        }
}
