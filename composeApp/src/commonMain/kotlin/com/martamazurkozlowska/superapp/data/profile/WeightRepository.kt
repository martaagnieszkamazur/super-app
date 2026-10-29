package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.storage.WeightStorageManager
import kotlinx.coroutines.flow.Flow

class WeightRepository(
    private val storageManager: WeightStorageManager,
) {
    fun getWeight(): Flow<Float> {
        return storageManager.getWeight()
    }

    suspend fun setWeight(weight: Float) {
        storageManager.setWeight(weight = weight)
    }
}