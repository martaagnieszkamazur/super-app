package com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients

import androidx.compose.ui.graphics.Color
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import org.jetbrains.compose.resources.StringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.calories
import superapp.composeapp.generated.resources.carbohydrates
import superapp.composeapp.generated.resources.fats
import superapp.composeapp.generated.resources.grams
import superapp.composeapp.generated.resources.kcal
import superapp.composeapp.generated.resources.protein

enum class NutrientTypeUiModel(
    val nutrientName: StringResource,
    val abbreviation:String?,
    val color: Color,
    val secondaryColor: Color,
    val unit: StringResource,
) {
    Calories(
        nutrientName = Res.string.calories,
        abbreviation = null,
        color = AppColors.lime600,
        secondaryColor = AppColors.limeSecondary,
        unit = Res.string.kcal,
    ),

    Protein(
        nutrientName = Res.string.protein,
        abbreviation = "B:",
        color = AppColors.cyanPrimary,
        secondaryColor = AppColors.cyanSecondary,
        unit = Res.string.grams,
    ),

    Carbohydrates(
        nutrientName = Res.string.carbohydrates,
        abbreviation = "W:",
        color = AppColors.fuchsiaPrimary,
        secondaryColor = AppColors.fuchsiaSecondary,
        unit = Res.string.grams
    ),

    Fats(
        nutrientName = Res.string.fats,
        abbreviation = "T:",
        color = AppColors.orangePrimary,
        secondaryColor = AppColors.orangeSecondary,
        unit = Res.string.grams,
    ),
}