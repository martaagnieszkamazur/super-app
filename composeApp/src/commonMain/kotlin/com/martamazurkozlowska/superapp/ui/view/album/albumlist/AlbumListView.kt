package com.martamazurkozlowska.superapp.ui.view.album.albumlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.martamazurkozlowska.superapp.ui.components.album.AlbumItemView
import com.martamazurkozlowska.superapp.ui.theme.AppColors

@Composable
fun AlbumListView(
    albumList: List<AlbumUiModel>,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.gray300)
    ) {
        LazyColumn(
        ) {
            items(items = albumList) { it ->
                AlbumItemView(itemName = it.title, onItemClick = onItemClick)
            }
        }
    }
}