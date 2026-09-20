package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.storage.WeightStorageManager
import kotlinx.coroutines.flow.Flow

class WeightRepository(
    private val storageManager: WeightStorageManager,
) {
    fun getWeight(): Flow<Double> {
        return storageManager.getWeight()
    }

    suspend fun setWeight(weight: Double) {
        storageManager.setWeight(weight = weight)
    }
}