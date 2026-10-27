package com.martamazurkozlowska.superapp.app.nutripulse.profile

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.nutripulse.profile.NutriPulseProfileView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NutriPulseProfileScreen(
    viewModel: NutriPulseProfileViewModel = koinViewModel()
){
    NutriPulseProfileView()
}