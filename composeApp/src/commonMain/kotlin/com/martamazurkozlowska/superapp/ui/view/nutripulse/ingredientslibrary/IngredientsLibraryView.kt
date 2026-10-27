package com.martamazurkozlowska.superapp.ui.view.nutripulse.ingredientslibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem.IngredientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem.IngredientItemView
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientTypeUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientsUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.screentitle.ScreenTitleView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.ingredients_librabry
import superapp.composeapp.generated.resources.search_for_ingredient

@Composable
fun IngredientsLibraryView(
    ingredient: IngredientItemUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.nutriBackgroud)
            .padding(24.dp)
    ) {
        ScreenTitleView(
            text1 = stringResource(Res.string.ingredients_librabry),
            text2 = stringResource(Res.string.search_for_ingredient)
        )

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "kategorie"
            )
        }

        IngredientItemView(
            ingredient = ingredient
        )
    }
}

@Preview
@Composable
private fun IngredientsLibraryViewPreview() = AppTheme {
    IngredientsLibraryView(
        ingredient = IngredientItemUiModel(
            ingredientName = "Banan",
            category = "Owoc",
            nutrients = NutrientsUiModel(
                calories = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Calories,
                    value = 100f
                ),
                protein = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Protein,
                    value = 15.0f
                ),
                carbohydrates = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Carbohydrates,
                    value = 15.2f
                ),
                fats = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Fats,
                    value = 0.5f
                ),
            )
        )
    )
}