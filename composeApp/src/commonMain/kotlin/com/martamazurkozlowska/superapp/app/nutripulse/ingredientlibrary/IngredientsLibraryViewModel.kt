package com.martamazurkozlowska.superapp.app.nutripulse.ingredientlibrary

import androidx.lifecycle.ViewModel
import com.martamazurkozlowska.superapp.data.nutripulse.addingredient.IngredientsRepository
import com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem.IngredientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientTypeUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientsUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class IngredientsLibraryViewModel(
    ingredientsRepository: IngredientsRepository,
) : ViewModel() {

    private val ingredientItem = MutableStateFlow<IngredientItemUiModel>(
        value = IngredientItemUiModel(
            ingredientName = "Banan",
            category = "Owoc",
            nutrients = NutrientsUiModel(
                calories = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Calories, value = 0f,
                ),
                protein = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Protein, value = 0f,
                ),
                carbohydrates = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Carbohydrates, value = 0f,
                ),
                fats = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Fats, value = 0f,
                ),
            )
        )
    )
    val ingredientItemFlow = ingredientItem.asStateFlow()

}