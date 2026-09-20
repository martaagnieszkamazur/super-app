package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.storage.GenderStorageManager
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GenderRepository(
    private val storageManager: GenderStorageManager,
) {

    fun getSelectedGender(): Flow<GenderUiModel> {
        val gender = storageManager.getSelectedGender().map {
            it.toUiModel()
        }
        return gender
    }

    suspend fun saveGender(
        gender: GenderUiModel,
    ) {
        val gender = gender.toApiModel()
        storageManager.setSelectedGender(gender)
    }
}