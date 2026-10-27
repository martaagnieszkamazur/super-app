package com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem

import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientsUiModel

data class IngredientItemUiModel(
    val ingredientName: String,
    val category: String,
    val nutrients: NutrientsUiModel,
)