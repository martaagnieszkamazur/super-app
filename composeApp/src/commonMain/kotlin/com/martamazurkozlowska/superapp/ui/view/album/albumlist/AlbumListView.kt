package com.martamazurkozlowska.superapp.ui.view.album.albumlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.martamazurkozlowska.superapp.ui.theme.AppColors

@Composable
fun AlbumListView(
    albumList: List<AlbumUiModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.gray300)
    ) {
        LazyColumn {
        }
    }
}