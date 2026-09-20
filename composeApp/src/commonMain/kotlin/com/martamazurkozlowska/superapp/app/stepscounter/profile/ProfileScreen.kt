package com.martamazurkozlowska.superapp.app.stepscounter.profile

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.stepscounter.profile.ProfileView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val selectedGender by viewModel.selectedGenderFlow.collectAsStateWithLifecycle()
    val personalGoalInKilos = viewModel.personalGoalTextState
    val height = viewModel.heightTextState
    val weight = viewModel.weightTextState

    ProfileView(
        selectedGender = selectedGender,
        personalGoal = personalGoalInKilos,
        isPersonalGoalEmpty = false,
        height = height,
        isHeightFieldEmpty = false,
        weight = weight,
        isWeightFieldEmpty = false,
        onBackClick = onBackClick,
        onGenderSelected = viewModel::onGenderSelected,
        onSaveProfileClick = {
            viewModel.onSaveProfile()
            onBackClick()
        },
    )
}