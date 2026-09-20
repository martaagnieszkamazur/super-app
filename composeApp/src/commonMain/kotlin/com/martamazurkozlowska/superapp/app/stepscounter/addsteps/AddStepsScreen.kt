package com.martamazurkozlowska.superapp.app.stepscounter.addsteps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps.AddStepsView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddStepsScreen(
    viewModel: AddStepsViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val selectedDateText by viewModel.selectedDateTextFlow.collectAsStateWithLifecycle()

    AddStepsView(
        stepsCount = viewModel.stepsCountTextState,
        isStepsCountEmpty = false,
        selectedDateText = selectedDateText,
        onBackClick = onBackClick,
        onSaveStepsClick = viewModel::onSaveStepsClick,
        onDateSelected = viewModel::onDateSelected,
    )
}