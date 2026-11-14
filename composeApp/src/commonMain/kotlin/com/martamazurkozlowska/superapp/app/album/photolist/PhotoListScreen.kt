package com.martamazurkozlowska.superapp.app.album.photolist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.album.photolist.PhotoListView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PhotoListScreen(
    viewModel: PhotoListViewModel = koinViewModel(),
    albumId: Long,
    onBackClick: () -> Unit,
) {
    val photoList by viewModel.photoListFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.init(albumId)
    }

    PhotoListView(
        photoList = photoList,
        onBackClick = onBackClick,
    )
}