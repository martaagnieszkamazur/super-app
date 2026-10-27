package com.martamazurkozlowska.superapp.app.nutripulse.addmeal

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.ui.view.nutripulse.addmeal.AddMealView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddMealScreen(
    viewModel: AddMealViewModel = koinViewModel()
){
    AddMealView()
}