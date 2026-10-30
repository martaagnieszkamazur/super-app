package com.martamazurkozlowska.superapp.app.main

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.main.MainView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    onStepsCounterAppClick: () -> Unit,
    onNutriPulseAppClick: () -> Unit,
    onTestClick: () -> Unit,
    viewModel: MainViewModel = koinViewModel(),
) {
    MainView(
        onStepsCounterAppClick = onStepsCounterAppClick,
        onNutriPulseAppClick = onNutriPulseAppClick,
        onTestClick = onTestClick,
    )
}