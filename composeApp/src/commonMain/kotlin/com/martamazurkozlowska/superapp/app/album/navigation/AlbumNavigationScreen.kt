package com.martamazurkozlowska.superapp.app.album.navigation

import Route
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.martamazurkozlowska.superapp.app.album.albumlist.AlbumListScreen
import com.martamazurkozlowska.superapp.app.album.photolist.PhotoListScreen
import com.martamazurkozlowska.superapp.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.superapp.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.superapp.ui.theme.AppColors

@Composable
fun AlbumNavigationScreen() {
    val backStack = rememberNavBackStack(configuration = Route.config, Route.AlbumNav.AlbumList)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StatusBar(
            color = AppColors.limeWhite
        )

        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<Route.AlbumNav.AlbumList> {
                    AlbumListScreen(
                        onAlbumItemClick = { backStack.add(Route.AlbumNav.PhotoList(albumId = it)) }
                    )
                }

                entry<Route.AlbumNav.PhotoList> {
                    PhotoListScreen(
                        albumId = it.albumId,
                        onBackClick = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
            },
            modifier = Modifier.weight(1f)
        )

        NavigationBar(
            color = AppColors.limeWhite
        )
    }
}