package com.martamazurkozlowska.superapp.ui.components.sexitem

import org.jetbrains.compose.resources.StringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.man
import superapp.composeapp.generated.resources.woman

enum class GenderUiModel(
    val titleRes: StringResource,
    val stepLengthInCm: Int,
    val caloriesBurntPer1000Steps: Int,
) {
    Female(
        titleRes = Res.string.woman,
        stepLengthInCm = 70,
        caloriesBurntPer1000Steps = 40,
    ),
    Male(
        titleRes = Res.string.man,
        stepLengthInCm = 78,
        caloriesBurntPer1000Steps = 42,
    ),
}