package com.martamazurkozlowska.superapp.ui.components.test.radiobuttons

import androidx.compose.ui.graphics.Color
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import org.jetbrains.compose.resources.StringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.option1
import superapp.composeapp.generated.resources.option2
import superapp.composeapp.generated.resources.option3

enum class TestRadioButtonUiModel(
    val text: StringResource,
    val color: Color,
) {
    Option1(
        text = Res.string.option1,
        color = AppColors.lime600,
    ),

    Option2(
        text = Res.string.option2,
        color = AppColors.fuchsia400,
    ),

    Option3(
        text = Res.string.option3,
        color = AppColors.orange400,
    )
}