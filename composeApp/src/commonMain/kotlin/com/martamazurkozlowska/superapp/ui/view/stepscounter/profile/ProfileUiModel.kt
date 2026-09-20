package com.martamazurkozlowska.superapp.ui.view.stepscounter.profile

import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel

data class ProfileUiModel(
    val gender: GenderUiModel,
    val dailyStepsGoal: Int,
    val personalGoalInKilos: Double,
    val stepLengthInCentimeters: Int,
    val caloriesBurnt: Int,
)