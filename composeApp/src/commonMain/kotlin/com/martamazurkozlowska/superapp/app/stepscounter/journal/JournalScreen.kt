package com.martamazurkozlowska.superapp.app.stepscounter.journal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import com.martamazurkozlowska.superapp.ui.view.stepscounter.journal.JournalView
import com.martamazurkozlowska.superapp.ui.view.stepscounter.profile.ProfileUiModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun JournalScreen(
    viewModel: JournalViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val stepsList by viewModel.stepsListFlow.collectAsStateWithLifecycle()

    JournalView(
        items = stepsList,
        profileUiModel = ProfileUiModel(
            gender = GenderUiModel.Female,
            dailyStepsGoal = 6000,
            personalGoalInKilos = 5.0,
            stepLengthInCentimeters = 75,
            caloriesBurnt = 100,
        ),
        onBackCLick = onBackClick,
    )
}