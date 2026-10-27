package com.martamazurkozlowska.superapp.app.nutripulse.ingredientlibrary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.nutripulse.ingredientslibrary.IngredientsLibraryView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun IngredientsLibraryScreen(
    viewModel: IngredientsLibraryViewModel = koinViewModel(),
) {
    val ingredient by viewModel.ingredientItemFlow.collectAsStateWithLifecycle()

    IngredientsLibraryView(
        ingredient = ingredient
    )
}