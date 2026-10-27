package com.martamazurkozlowska.superapp.data.nutripulse.addingredient

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem.IngredientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientsUiModel

@Composable
fun IngredientItemUiModel.toApiModel() =
    IngredientItemApiModel(
        ingredientName = ingredientName,
        category = category,
        nutrients = nutrients.toApiModel(),
    )

@Composable
fun IngredientItemApiModel.toUiModel() =
    IngredientItemUiModel(
        ingredientName = ingredientName,
        category = category,
        nutrients = nutrients.toUiModel(),
    )

@Composable
fun NutrientsUiModel.toApiModel() =
    NutrientsApiModel(
        calories = calories.toApiModel(),
        protein = protein.toApiModel(),
        carbohydrates = carbohydrates.toApiModel(),
        fats = fats.toApiModel(),
    )

@Composable
fun NutrientsApiModel.toUiModel() =
    NutrientsUiModel(
        calories = calories.toUiModel(),
        protein = protein.toUiModel(),
        carbohydrates = carbohydrates.toUiModel(),
        fats = fats.toUiModel(),
    )

@Composable
fun NutrientItemUiModel.toApiModel() =
    NutrientItemApiModel(
        type = type,
        value = value,
    )

@Composable
fun NutrientItemApiModel.toUiModel() =
    NutrientItemUiModel(
        type = type,
        value = value,
    )