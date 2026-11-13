package com.martamazurkozlowska.superapp.ui.view.album.photolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.album.PhotoItemView
import com.martamazurkozlowska.superapp.ui.components.topappbar.TopAppBarView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.albums

@Composable
fun PhotoListView(
    photoList: List<PhotoUiModel>,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.limeWhite)
            .padding(24.dp)
    ) {
        TopAppBarView(
            title = stringResource(Res.string.albums),
            onBackClick = onBackClick,
            modifier = Modifier.background(color = AppColors.blue800)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 64.dp),
        ) {
            items(items = photoList) {
                PhotoItemView(
                    itemName = it.id.toString(),
                    modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PhotoListViewPreview() = AppTheme {
    PhotoListView(
        photoList = emptyList(),
        onBackClick = {},
    )
}