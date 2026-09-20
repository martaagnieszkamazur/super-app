package com.martamazurkozlowska.superapp.app

import Route
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.martamazurkozlowska.superapp.app.main.MainScreen
import com.martamazurkozlowska.superapp.app.stepscounter.navigation.StepsNavigationScreen
import com.martamazurkozlowska.superapp.app.test.TestScreen

@Composable
fun MainNavigationScreen() {
    val backStack = rememberNavBackStack(Route.config, Route.StepsCounter)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Route.Main> {
                MainScreen(
                    onStepsCounterAppClick = {
                        backStack.add(Route.StepsCounter)
                    },
                    onTestClick = {
                        backStack.add(Route.Test)
                    }
                )
            }

            entry<Route.StepsCounter> {
                StepsNavigationScreen()
            }

            entry<Route.Test> {
                TestScreen()
            }
        }
    )
}