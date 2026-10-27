package com.martamazurkozlowska.superapp.ui.view.nutripulse.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.ui.theme.AppTheme

@Composable
fun NutriPulseProfileView() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Profile"
        )
    }
}

@Preview
@Composable
private fun NutriPulseProfileViewPreview() = AppTheme {
    NutriPulseProfileView()
}