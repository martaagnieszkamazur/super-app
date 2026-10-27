package com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients

data class NutrientsUiModel(
    val calories: NutrientItemUiModel,
    val protein: NutrientItemUiModel,
    val carbohydrates: NutrientItemUiModel,
    val fats: NutrientItemUiModel,
)

data class NutrientItemUiModel(
    val type: NutrientTypeUiModel,
    val value: Float,
)