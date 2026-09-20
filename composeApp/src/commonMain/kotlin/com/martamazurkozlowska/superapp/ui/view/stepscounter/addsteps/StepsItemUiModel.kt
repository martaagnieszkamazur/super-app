package com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps

import kotlinx.serialization.Serializable

@Serializable
data class StepsItemUiModel(
    val stepsCount: Int,
    val date: Long?,
)
