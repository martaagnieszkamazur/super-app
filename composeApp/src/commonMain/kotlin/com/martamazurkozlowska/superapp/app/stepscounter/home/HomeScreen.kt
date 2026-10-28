package com.martamazurkozlowska.superapp.app.stepscounter.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.ui.view.stepscounter.home.HomeView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onAddStepsClick: () -> Unit,
) {
    val stepsSumValue by viewModel.totalStepsFlow.collectAsStateWithLifecycle()
    val kilometersSum by viewModel.kilometersFlow.collectAsStateWithLifecycle()

    HomeView(
        stepsGoal = 200000,
        stepsSumValue = stepsSumValue.toString(),
        caloriesSumValue = "",
        kilometersSumValue = kilometersSum.toString(),
        onAddStepsClick = onAddStepsClick,
    )
}