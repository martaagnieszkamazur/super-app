package com.martamazurkozlowska.superapp.ui.components.album

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun AlbumItemView(
    itemName: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        TextButton(
            onClick = onItemClick,
            colors = ButtonColors(
                containerColor = AppColors.lime600,
                contentColor = AppColors.limeWhite,
                disabledContentColor = AppColors.text,
                disabledContainerColor = AppColors.gray400,
            ),
            content = {
                Text(
                    text = itemName,
                    style = AppTypography.bodyMediumRegular,
                )
            }
        )
    }
}

@Preview
@Composable
private fun AlbumItemViewPreview() = AppTheme {
    AlbumItemView(
        itemName = "Pieski",
        onItemClick = {},
    )
}