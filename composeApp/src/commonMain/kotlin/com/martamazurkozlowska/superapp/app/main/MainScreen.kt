package com.martamazurkozlowska.superapp.app.main

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.main.MainView

@Composable
fun MainScreen(
    onStepsCounterAppClick: () -> Unit,
    onTestClick: () -> Unit,
) {
    MainView(
        onStepsCounterAppClick = onStepsCounterAppClick,
        onTestClick = onTestClick,
    )
}