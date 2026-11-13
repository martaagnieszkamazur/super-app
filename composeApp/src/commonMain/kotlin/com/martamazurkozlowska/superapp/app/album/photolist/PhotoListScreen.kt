package com.martamazurkozlowska.superapp.app.album.albumlist.photolist

import androidx.compose.runtime.Composable
import com.martamazurkozlowska.superapp.app.album.photolist.PhotoListViewModel
import com.martamazurkozlowska.superapp.ui.view.album.photolist.PhotoListView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PhotoListScreen(
    viewModel: PhotoListViewModel = koinViewModel(),
) {
    PhotoListView()
}