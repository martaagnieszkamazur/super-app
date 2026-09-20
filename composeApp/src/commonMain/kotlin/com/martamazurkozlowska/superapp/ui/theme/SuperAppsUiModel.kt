package com.martamazurkozlowska.superapp.ui.theme

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.StringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.steps_counter
import superapp.composeapp.generated.resources.test

enum class SuperAppsUiModel(
    val color: Color,
    val appName: StringResource,
) {
    StepsCounter(
        color = AppColors.green800,
        appName = Res.string.steps_counter,
    ),

    Test(
        color = AppColors.blue800,
        appName = Res.string.test,
    )
}