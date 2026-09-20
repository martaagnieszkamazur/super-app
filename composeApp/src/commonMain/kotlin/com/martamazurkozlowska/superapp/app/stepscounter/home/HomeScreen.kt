package com.martamazurkozlowska.superapp.app.stepscounter.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.stepscounter.home.HomeView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onAddStepsClick: () -> Unit,
) {
    val stepsSumValue by viewModel.totalStepsFlow.collectAsStateWithLifecycle()

    HomeView(
        stepsSumValue = stepsSumValue.toString(),
        caloriesSumValue = "",
        kilometersSumValue = "",
        onAddStepsClick = onAddStepsClick,
    )
}