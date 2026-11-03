package com.martamazurkozlowska.superapp.app.album.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.album.AlbumListRepository
import com.martamazurkozlowska.superapp.ui.view.album.albumlist.AlbumUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AlbumListViewModel(
    repository: AlbumListRepository,
) : ViewModel() {

    private val albumList = MutableStateFlow<List<AlbumUiModel>>(emptyList())
    val albumListFlow = albumList.asStateFlow()

    init {
        viewModelScope.launch {
            albumList.value = repository.getAlbumList()
        }
    }
}