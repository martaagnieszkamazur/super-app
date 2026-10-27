package com.martamazurkozlowska.superapp.ui.view.nutripulse.journal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.ui.theme.AppTheme

@Composable
fun NutriPulseJournalView(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Journal"
        )
    }
}

@Preview
@Composable
private fun NutriPulseJournalViewPreview() = AppTheme {
    NutriPulseJournalView()
}