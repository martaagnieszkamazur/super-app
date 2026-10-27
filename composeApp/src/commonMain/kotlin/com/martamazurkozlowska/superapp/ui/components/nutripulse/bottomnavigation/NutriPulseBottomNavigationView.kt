package com.martamazurkozlowska.superapp.ui.components.nutripulse.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme

@Composable
fun NutriPulseBottomNavigationView(
    selectedItem: NutriPulseBottomNavigationUiModel,
    onHomeClick: () -> Unit,
    onAddMealClick: () -> Unit,
    onAddIngredientClick: () -> Unit,
    onJournalClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.nutriBackgroud)
    ) {
        HorizontalDivider(
            color = AppColors.lime200
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(all = 12.dp)
        ) {
            NutriPulseBottomNavigationItemView(
                navigationItemUiModel = NutriPulseBottomNavigationUiModel.Home,
                selected = selectedItem == NutriPulseBottomNavigationUiModel.Home,
                onItemClick = onHomeClick,
                modifier = Modifier.weight(1f)
            )

            NutriPulseBottomNavigationItemView(
                navigationItemUiModel = NutriPulseBottomNavigationUiModel.AddMeal,
                selected = selectedItem == NutriPulseBottomNavigationUiModel.AddMeal,
                onItemClick = onAddMealClick,
                modifier = Modifier.weight(1f)
            )

            NutriPulseBottomNavigationItemView(
                navigationItemUiModel = NutriPulseBottomNavigationUiModel.AddIngredient,
                selected = selectedItem == NutriPulseBottomNavigationUiModel.AddIngredient,
                onItemClick = onAddIngredientClick,
                modifier = Modifier.weight(1f)
            )

            NutriPulseBottomNavigationItemView(
                navigationItemUiModel = NutriPulseBottomNavigationUiModel.Journal,
                selected = selectedItem == NutriPulseBottomNavigationUiModel.Journal,
                onItemClick = onJournalClick,
                modifier = Modifier.weight(1f)
            )

            NutriPulseBottomNavigationItemView(
                navigationItemUiModel = NutriPulseBottomNavigationUiModel.Profile,
                selected = selectedItem == NutriPulseBottomNavigationUiModel.Profile,
                onItemClick = onProfileClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
private fun NutriPulseBottomNavigationViewPreview() = AppTheme {
    NutriPulseBottomNavigationView(
        selectedItem = NutriPulseBottomNavigationUiModel.Home,
        onHomeClick = {},
        onAddMealClick = {},
        onAddIngredientClick = {},
        onJournalClick = {},
        onProfileClick = {},
    )
}