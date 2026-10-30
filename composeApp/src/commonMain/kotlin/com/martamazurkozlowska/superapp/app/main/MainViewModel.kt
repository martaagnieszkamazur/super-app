package com.martamazurkozlowska.superapp.app.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.album.AlbumListRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AlbumListRepository,
) : ViewModel() {

    init {
        viewModelScope.launch {
            val albumList = repository.getAlbumList()
        }
    }
}