package com.martamazurkozlowska.superapp.data.tasks

data class TaskUiModel(
    val id: Int,
    val title: String,
    val description: String?,
    val isDone: Boolean,
)
