package com.martamazurkozlowska.superapp.ui.components.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.martamazurkozlowska.superapp.ui.theme.AppColors

@Composable
fun NavigationBar(
    color: Color = AppColors.itemBackground,
) {
    val navigationBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(navigationBarHeight)
            .background(color = color)
    )
}