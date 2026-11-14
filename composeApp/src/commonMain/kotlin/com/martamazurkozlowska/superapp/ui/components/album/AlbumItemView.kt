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
import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumUiModel

@Composable
fun AlbumItemView(
    item: AlbumUiModel,
    onItemClick: (albumId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        TextButton(
            onClick = { onItemClick(item.id) },
            colors = ButtonColors(
                containerColor = AppColors.lime600,
                contentColor = AppColors.limeWhite,
                disabledContentColor = AppColors.text,
                disabledContainerColor = AppColors.gray400,
            ),
            content = {
                Text(
                    text = item.title,
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
        item = AlbumUiModel(
            id = 1,
            title = "Pieski"
        ),
        onItemClick = {},
    )
}