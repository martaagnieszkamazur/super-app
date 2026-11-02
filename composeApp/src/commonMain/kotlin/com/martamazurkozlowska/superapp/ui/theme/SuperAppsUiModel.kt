package com.martamazurkozlowska.superapp.ui.theme

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.albums
import superapp.composeapp.generated.resources.nutri_pulse
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

    NutriPulse(
        color = AppColors.gray700,
        appName = Res.string.nutri_pulse,
    ),

    Test(
        color = AppColors.blue800,
        appName = Res.string.test,
    ),

    Album(
        color = AppColors.lime600,
        appName = Res.string.albums,
    )
}