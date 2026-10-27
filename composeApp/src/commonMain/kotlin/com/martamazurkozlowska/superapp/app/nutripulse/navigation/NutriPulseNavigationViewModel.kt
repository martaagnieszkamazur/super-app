package com.martamazurkozlowska.superapp.app.nutripulse.navigation

import androidx.lifecycle.ViewModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.bottomnavigation.NutriPulseBottomNavigationUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NutriPulseNavigationViewModel : ViewModel() {

    private val selectedItem =
        MutableStateFlow<NutriPulseBottomNavigationUiModel>(NutriPulseBottomNavigationUiModel.Home)
    val selectedItemFlow = selectedItem.asStateFlow()

    fun onHomeClick() {
        selectedItem.value = NutriPulseBottomNavigationUiModel.Home
    }

    fun onAddMealClick() {
        selectedItem.value = NutriPulseBottomNavigationUiModel.AddMeal
    }

    fun onAddIngredientClick() {
        selectedItem.value = NutriPulseBottomNavigationUiModel.AddIngredient
    }

    fun onJournalClick() {
        selectedItem.value = NutriPulseBottomNavigationUiModel.Journal
    }

    fun onProfileClick() {
        selectedItem.value = NutriPulseBottomNavigationUiModel.Profile
    }
}