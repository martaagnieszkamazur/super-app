package com.martamazurkozlowska.superapp.data.tasks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskApiModel(

    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String? = null,

    @SerialName("is_done")
    val isDone: Boolean = false,
)
