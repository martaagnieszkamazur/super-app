package com.martamazurkozlowska.superapp.data.addsteps

import com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps.StepsItemUiModel

fun StepsItemUiModel.toApiModel() =
    StepsItemApiModel(
        stepsCount = stepsCount,
        date = date,
    )

fun StepsItemApiModel.toUiModel() =
    StepsItemUiModel(
        stepsCount = stepsCount,
        date = date,
    )