package com.martamazurkozlowska.superapp.ui.view.album.photolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun PhotoListView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.limeWhite)
            .padding(24.dp)
    ) {
        Text(
            text = "Photo list view",
            style = AppTypography.h3Bold,
            color = AppColors.gray800,
        )
    }
}

@Preview
@Composable
private fun PhotoListViewPreview() = AppTheme {
    PhotoListView()
}