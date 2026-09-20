package com.martamazurkozlowska.superapp.app.stepscounter.navigation

import androidx.lifecycle.ViewModel
import com.martamazurkozlowska.superapp.ui.components.bottomnavigation.BottomNavigationItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationViewModel() : ViewModel() {
    private val selectedItem = MutableStateFlow<BottomNavigationItemUiModel>(BottomNavigationItemUiModel.Home)
    val selectedItemFlow = selectedItem.asStateFlow()

    fun onHomeClick() {
        selectedItem.value = BottomNavigationItemUiModel.Home
    }

    fun onJournalClick() {
        selectedItem.value = BottomNavigationItemUiModel.Journal
    }

    fun onProfileClick() {
        selectedItem.value = BottomNavigationItemUiModel.Profile
    }

    fun onTabChange(tab: BottomNavigationItemUiModel) {
        selectedItem.value = tab
    }
}