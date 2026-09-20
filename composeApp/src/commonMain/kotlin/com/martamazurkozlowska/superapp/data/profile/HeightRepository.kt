package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.storage.HeightStorageManager
import kotlinx.coroutines.flow.Flow

class HeightRepository(
    private val storageManager: HeightStorageManager,
) {
    fun getHeight(): Flow<Int> {
        return storageManager.getHeight()
    }

    suspend fun setHeight(height:Int){
        storageManager.setHeight(height = height)
    }
}