package com.martamazurkozlowska.superapp.app.nutripulse.home

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.nutripulse.home.NutriPulseHomeView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NutriPulseHomeScreen(
    viewModel: NutriPulseHomeViewModel = koinViewModel(),
) {
    NutriPulseHomeView()
}