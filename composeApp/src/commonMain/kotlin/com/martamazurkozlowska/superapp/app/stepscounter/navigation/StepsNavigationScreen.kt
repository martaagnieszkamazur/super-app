package com.martamazurkozlowska.superapp.app.stepscounter.navigation

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
import com.martamazurkozlowska.superapp.app.stepscounter.addsteps.AddStepsScreen
import com.martamazurkozlowska.superapp.app.stepscounter.home.HomeScreen
import com.martamazurkozlowska.superapp.app.stepscounter.journal.JournalScreen
import com.martamazurkozlowska.superapp.app.stepscounter.profile.ProfileScreen
import com.martamazurkozlowska.superapp.ui.components.bottomnavigation.BottomNavigationItemUiModel
import com.martamazurkozlowska.superapp.ui.components.bottomnavigation.BottomNavigationView
import com.martamazurkozlowska.superapp.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.superapp.ui.components.statusbar.StatusBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun StepsNavigationScreen(
    viewModel: NavigationViewModel = koinViewModel(),
) {
    val backStack = rememberNavBackStack(Route.config, Route.StepsCounterNav.Home)
    val selectedItem by viewModel.selectedItemFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StatusBar()

        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<Route.StepsCounterNav.Home> {
                    HomeScreen(
                        onAddStepsClick = { backStack.add(Route.StepsCounterNav.AddSteps) }
                    )
                }

                entry<Route.StepsCounterNav.Journal> {
                    JournalScreen(
                        onBackClick = {
                            backStack.clear()
                            backStack.add(Route.StepsCounterNav.Home)
                            viewModel.onTabChange(BottomNavigationItemUiModel.Home)
                        }
                    )
                }

                entry<Route.StepsCounterNav.Profile> {
                    ProfileScreen(
                        onBackClick = {
                            backStack.clear()
                            backStack.add(Route.StepsCounterNav.Home)
                            viewModel.onTabChange(BottomNavigationItemUiModel.Home)
                        }
                    )
                }

                entry<Route.StepsCounterNav.AddSteps> {
                    AddStepsScreen(
                        onBackClick = { backStack.removeLastOrNull() }
                    )
                }
            },
            modifier = Modifier.weight(1f)
        )

        BottomNavigationView(
            selectedItem = selectedItem,
            onHomeClick = {
                viewModel.onHomeClick()
                backStack.clear()
                backStack.add(Route.StepsCounterNav.Home)
            },
            onJournalClick = {
                viewModel.onJournalClick()
                backStack.clear()
                backStack.add(Route.StepsCounterNav.Journal)
            },
            onProfileClick = {
                viewModel.onProfileClick()
                backStack.clear()
                backStack.add(Route.StepsCounterNav.Profile)
            },
        )

        NavigationBar()
    }
}