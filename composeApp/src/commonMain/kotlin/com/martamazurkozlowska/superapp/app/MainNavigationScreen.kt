package com.martamazurkozlowska.superapp.app

import Route
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.martamazurkozlowska.superapp.app.album.navigation.AlbumNavigationScreen
import com.martamazurkozlowska.superapp.app.main.MainScreen
import com.martamazurkozlowska.superapp.app.nutripulse.navigation.NutriPulseNavigationScreen
import com.martamazurkozlowska.superapp.app.stepscounter.navigation.StepsNavigationScreen
import com.martamazurkozlowska.superapp.app.test.TestScreen

@Composable
fun MainNavigationScreen() {
    val backStack = rememberNavBackStack(Route.config, Route.Main)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = entryProvider {
            entry<Route.Main> {
                MainScreen(
                    onStepsCounterAppClick = {
                        backStack.add(Route.StepsCounter)
                    },
                    onNutriPulseAppClick = {
                        backStack.add(Route.NutriPulse)
                    },
                    onTestClick = {
                        backStack.add(Route.Test)
                    },
                    onAlbumsClick = {
                        backStack.add(Route.Albums)
                    }
                )
            }

            entry<Route.StepsCounter> {
                StepsNavigationScreen()
            }

            entry<Route.NutriPulse> {
                NutriPulseNavigationScreen()
            }

            entry<Route.Test> {
                TestScreen()
            }

            entry<Route.Albums> {
                AlbumNavigationScreen()
            }
        }
    )
}