package com.martamazurkozlowska.superapp.app.album.albumlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumListView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AlbumListScreen(
    viewModel: AlbumListViewModel = koinViewModel(),
) {
    val albumList by viewModel.albumListFlow.collectAsStateWithLifecycle()

    AlbumListView(
        albumList = albumList,
        onItemClick = {},
    )
}