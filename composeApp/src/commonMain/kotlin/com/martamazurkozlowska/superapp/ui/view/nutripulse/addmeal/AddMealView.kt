package com.martamazurkozlowska.superapp.ui.view.nutripulse.addmeal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.ui.theme.AppTheme

@Composable
fun AddMealView(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Add meal"
        )
    }
}

@Preview
@Composable
private fun AddMealViewPreview() = AppTheme {
    AddMealView()
}