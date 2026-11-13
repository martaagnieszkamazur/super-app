package com.martamazurkozlowska.superapp.app.album.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.app.album.mapper.toUiModel
import com.martamazurkozlowska.superapp.data.album.photo.PhotoListRepository
import com.martamazurkozlowska.superapp.ui.view.album.photolist.PhotoUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoListViewModel(
    private val repository: PhotoListRepository,
) : ViewModel() {

    private val photoList = MutableStateFlow<List<PhotoUiModel>>(emptyList())
    val photoListFlow = photoList.asStateFlow()

    init {
        viewModelScope.launch {
            photoList.value = repository.getPhotoList(1).map { it.toUiModel() }
        }
    }
}