package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.ui.view.stepscounter.profile.ProfileUiModel

fun ProfileUiModel.toApiModel() =
    ProfileApiModel(
        gender = gender.toApiModel(),
        dailyStepsGoal = dailyStepsGoal,
        personalGoalInKilos = personalGoalInKilos,
        stepLengthInCentimeters = stepLengthInCentimeters,
        caloriesBurnt = caloriesBurnt,
    )

fun ProfileApiModel.toUiModel() =
    ProfileUiModel(
        gender = gender.toUiModel(),
        dailyStepsGoal = dailyStepsGoal,
        personalGoalInKilos = personalGoalInKilos,
        stepLengthInCentimeters = stepLengthInCentimeters,
        caloriesBurnt = caloriesBurnt,
    )