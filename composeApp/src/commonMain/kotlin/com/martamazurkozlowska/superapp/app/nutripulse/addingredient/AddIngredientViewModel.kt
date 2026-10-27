package com.martamazurkozlowska.superapp.app.nutripulse.addingredient

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.nutripulse.addingredient.IngredientsRepository
import kotlinx.coroutines.launch

class AddIngredientViewModel(
    private val ingredientsRepository: IngredientsRepository,
) : ViewModel() {

    val ingredientName = TextFieldState()

    val caloriesValue = TextFieldState()

    fun saveIngredient() {
        viewModelScope.launch {
            ingredientsRepository.setIngredient(
                name = ingredientName.text.toString(),
                calories = caloriesValue.text.toString().toFloat(),
            )
        }
    }
}