package com.martamazurkozlowska.superapp.app.nutripulse.navigation

import Route
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.martamazurkozlowska.superapp.app.nutripulse.addingredient.AddIngredientScreen
import com.martamazurkozlowska.superapp.app.nutripulse.addmeal.AddMealScreen
import com.martamazurkozlowska.superapp.app.nutripulse.home.NutriPulseHomeScreen
import com.martamazurkozlowska.superapp.app.nutripulse.ingredientlibrary.IngredientsLibraryScreen
import com.martamazurkozlowska.superapp.app.nutripulse.journal.NutriPulseJournalScreen
import com.martamazurkozlowska.superapp.app.nutripulse.profile.NutriPulseProfileScreen
import com.martamazurkozlowska.superapp.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.superapp.ui.components.nutripulse.bottomnavigation.NutriPulseBottomNavigationView
import com.martamazurkozlowska.superapp.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NutriPulseNavigationScreen(
    viewModel: NutriPulseNavigationViewModel = koinViewModel(),
) {
    val backStack = rememberNavBackStack(Route.config, Route.NutriPulseNav.Home)
    val selectedItem by viewModel.selectedItemFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StatusBar(
            color = AppColors.nutriBackgroud
        )

        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<Route.NutriPulseNav.Home> {
                    NutriPulseHomeScreen()
                }

                entry<Route.NutriPulseNav.AddMeal> {
                    AddMealScreen()
                }

                entry<Route.NutriPulseNav.AddIngredient> {
                    AddIngredientScreen(
                        onIngredientsLibraryClick = { backStack.add(Route.NutriPulseNav.IngredientsLibrary) }
                    )
                }

                entry<Route.NutriPulseNav.IngredientsLibrary>{
                    IngredientsLibraryScreen()
                }

                entry<Route.NutriPulseNav.Journal> {
                    NutriPulseJournalScreen()
                }

                entry<Route.NutriPulseNav.Profile> {
                    NutriPulseProfileScreen()
                }
            },
            modifier = Modifier.weight(1f)
        )

        NutriPulseBottomNavigationView(
            selectedItem = selectedItem,
            onHomeClick = {
                viewModel.onHomeClick()
                backStack.clear()
                backStack.add(Route.NutriPulseNav.Home)
            },
            onAddMealClick = {
                viewModel.onAddMealClick()
                backStack.clear()
                backStack.add(Route.NutriPulseNav.AddMeal)
            },
            onAddIngredientClick = {
                viewModel.onAddIngredientClick()
                backStack.clear()
                backStack.add(Route.NutriPulseNav.AddIngredient)
            },
            onJournalClick = {
                viewModel.onJournalClick()
                backStack.clear()
                backStack.add(Route.NutriPulseNav.Journal)
            },
            onProfileClick = {
                viewModel.onProfileClick()
                backStack.clear()
                backStack.add(Route.NutriPulseNav.Profile)
            }
        )

        NavigationBar(
            color = AppColors.nutriBackgroud
        )
    }
}