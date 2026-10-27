package com.martamazurkozlowska.superapp.app.nutripulse.journal

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.nutripulse.journal.NutriPulseJournalView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NutriPulseJournalScreen(
    viewModel: NutriPulseJournalViewModel = koinViewModel()
){
    NutriPulseJournalView()
}