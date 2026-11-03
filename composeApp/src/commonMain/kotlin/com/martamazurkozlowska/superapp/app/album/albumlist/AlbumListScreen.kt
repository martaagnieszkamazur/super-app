package com.martamazurkozlowska.superapp.app.album.albumlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumListView

@Composable
fun AlbumListScreen(
    viewModel: AlbumListViewModel,
) {
    val albumList by viewModel.albumListFlow.collectAsStateWithLifecycle()

    AlbumListView(
        albumList = albumList,
        onItemClick = {},
    )
}