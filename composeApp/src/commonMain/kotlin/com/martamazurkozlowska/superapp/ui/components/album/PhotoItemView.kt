package com.martamazurkozlowska.superapp.ui.components.album

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun PhotoItemView(
    itemName: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(color = AppColors.bluePrimary, shape = AppShapes.item)
            .padding(16.dp)
    ) {
        Text(
            text = itemName,
            style = AppTypography.bodyMediumRegular,
        )
    }
}

@Preview
@Composable
private fun PhotoItemViewPreview() = AppTheme {
    PhotoItemView(
        itemName = "Zdjęcie 1"
    )
}