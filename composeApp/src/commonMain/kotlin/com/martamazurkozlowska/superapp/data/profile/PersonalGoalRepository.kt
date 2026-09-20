package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.storage.PersonalGoalStorageManager
import kotlinx.coroutines.flow.Flow

class PersonalGoalRepository(
    private val storageManager: PersonalGoalStorageManager,
) {
    fun getPersonalGoalInKilos(): Flow<Double> {
        return storageManager.getPersonalGoalInKilos()
    }

    suspend fun savePersonalGoalInKilos(
        personalGoalInKilos: Double,
    ) {
        storageManager.setPersonalGoalInKilos(goal = personalGoalInKilos)
    }
}