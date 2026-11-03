package com.martamazurkozlowska.superapp.ui.view.album.albumlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.ui.components.album.AlbumItemView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme

@Composable
fun AlbumListView(
    albumList: List<AlbumUiModel>,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.limeWhite)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = albumList) {
                AlbumItemView(itemName = it.title, onItemClick = onItemClick)
            }
        }
    }
}

@Preview
@Composable
private fun AlbumListViewPreview() = AppTheme {
    AlbumListView(
        albumList = listOf(AlbumUiModel(id = 1, title = "Pieski"), AlbumUiModel(2, "Kotki"), AlbumUiModel(3, "Koniki")),
        onItemClick = {},
    )
}