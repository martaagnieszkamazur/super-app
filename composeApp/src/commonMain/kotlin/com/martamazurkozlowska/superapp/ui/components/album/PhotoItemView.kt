package com.martamazurkozlowska.superapp.ui.components.album

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.view.album.photolist.PhotoUiModel

@Composable
fun PhotoItemView(
    item: PhotoUiModel,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = item.url,
        contentDescription = null,
        modifier = modifier.size(100.dp)
    )
}

@Preview
@Composable
private fun PhotoItemViewPreview() = AppTheme {
    PhotoItemView(
        item = PhotoUiModel(
            albumId = 1,
            id = 2,
            title = "reprehenderit est deserunt velit ipsam",
            url = "https://4rooms.com.pl/environment/cache/images/productGfx_1279cded36c5a39ffac5a8b86ffa654c_1000_1000.webp",
            thumbnailUrl = "https://picsum.photos/seed/2/150",
        ),
    )
}