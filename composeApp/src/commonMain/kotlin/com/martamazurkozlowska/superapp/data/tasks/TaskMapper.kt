package com.martamazurkozlowska.superapp.data.tasks

fun TaskApiModel.toUiModel() =
    TaskUiModel(
        id = id,
        title = title,
        description = description,
        isDone = isDone,
    )
