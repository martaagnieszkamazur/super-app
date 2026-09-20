package com.martamazurkozlowska.superapp.ui.components.stepssummary

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class StepsSummaryItemUiModel(
    val itemName: StringResource,
    val icon: DrawableResource,
    val value: String,
    val unit: String?,
    val tint: Color,
)