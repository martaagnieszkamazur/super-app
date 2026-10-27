package com.martamazurkozlowska.superapp.app.nutripulse.addingredient

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.nutripulse.addingredient.AddIngredientView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddIngredientScreen(
    viewModel: AddIngredientViewModel = koinViewModel(),
    onIngredientsLibraryClick: () -> Unit,
) {
    val ingredientName = viewModel.ingredientName

    AddIngredientView(
        newIngredientNameValue = ingredientName,
        caloriesValue = TextFieldState(),
        onSaveClick = viewModel::saveIngredient,
        onIngredientsLibraryClick = onIngredientsLibraryClick,
    )
}