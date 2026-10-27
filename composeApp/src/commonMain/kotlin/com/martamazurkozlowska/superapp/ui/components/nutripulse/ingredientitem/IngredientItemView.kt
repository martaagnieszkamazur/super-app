package com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientTypeUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientsUiModel
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.stringResource

@Composable
fun IngredientItemView(
    ingredient: IngredientItemUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = AppColors.nutriItemBackground, shape = AppShapes.item)
            .padding(16.dp)
    ) {
        Text(
            text = ingredient.ingredientName,
            style = AppTypography.h2Bold,
            color = AppColors.gray800
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = ingredient.category,
            style = AppTypography.bodyMediumRegular,
            color = AppColors.gray400,
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            NutrientValueView(
                nutrientItem = ingredient.nutrients.calories
            )

            NutrientValueView(
                nutrientItem = ingredient.nutrients.protein
            )

            NutrientValueView(
                nutrientItem = ingredient.nutrients.carbohydrates
            )

            NutrientValueView(
                nutrientItem = ingredient.nutrients.fats
            )
        }
    }
}

@Composable
private fun NutrientValueView(
    nutrientItem: NutrientItemUiModel,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = nutrientItem.type.secondaryColor, shape = AppShapes.circle)
            .padding(6.dp)
    ) {
        if (nutrientItem.type.abbreviation != null) {
            Text(
                text = nutrientItem.type.abbreviation,
                style = AppTypography.bodySmallBold,
                color = nutrientItem.type.color
            )
        }

        Spacer(
            modifier = Modifier.width(4.dp)
        )

        Text(
            text = nutrientItem.value.toString(),
            style = AppTypography.bodySmallLight,
            color = nutrientItem.type.color
        )

        Spacer(
            modifier = Modifier.width(2.dp)
        )

        Text(
            text = stringResource(nutrientItem.type.unit),
            style = AppTypography.bodySmallLight,
            color = nutrientItem.type.color,
        )
    }
}

@Preview
@Composable
private fun IngredientItemViewPreview() = AppTheme {
    IngredientItemView(
        ingredient = IngredientItemUiModel(
            ingredientName = "Banan",
            category = "Owoc",
            nutrients = NutrientsUiModel(
                calories = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Calories,
                    value = 120f,
                ),
                protein = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Protein,
                    value = 10.5f
                ),
                carbohydrates = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Carbohydrates,
                    value = 15.2f
                ),
                fats = NutrientItemUiModel(
                    type = NutrientTypeUiModel.Fats,
                    value = 0.5f
                )
            )
        ),
    )
}