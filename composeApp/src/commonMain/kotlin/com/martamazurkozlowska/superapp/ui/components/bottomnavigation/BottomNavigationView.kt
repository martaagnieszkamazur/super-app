package com.martamazurkozlowska.superapp.ui.components.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme

@Composable
fun BottomNavigationView(
    selectedItem: BottomNavigationItemUiModel,
    onHomeClick: () -> Unit,
    onJournalClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.gray700)
            .padding(vertical = 12.dp)
    ) {
        BottomNavigationItemView(
            item = BottomNavigationItemUiModel.Home,
            selected = selectedItem == BottomNavigationItemUiModel.Home,
            onClick = onHomeClick,
        )

        BottomNavigationItemView(
            item = BottomNavigationItemUiModel.Journal,
            selected = selectedItem == BottomNavigationItemUiModel.Journal,
            onClick = onJournalClick,
        )

        BottomNavigationItemView(
            item = BottomNavigationItemUiModel.Profile,
            selected = selectedItem == BottomNavigationItemUiModel.Profile,
            onClick = onProfileClick,
        )
    }
}

@Preview
@Composable
private fun BottomNavigationViewPreview() = AppTheme {
    BottomNavigationView(
        selectedItem = BottomNavigationItemUiModel.Journal,
        onHomeClick = {},
        onJournalClick = {},
        onProfileClick = {},
    )
}