package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.storage.PersonalGoalStorageManager
import kotlinx.coroutines.flow.Flow

class PersonalGoalRepository(
    private val storageManager: PersonalGoalStorageManager,
) {
    fun getPersonalGoalInKilos(): Flow<Float> {
        return storageManager.getPersonalGoalInKilos()
    }

    suspend fun savePersonalGoalInKilos(
        personalGoalInKilos: Float,
    ) {
        storageManager.setPersonalGoalInKilos(goal = personalGoalInKilos)
    }
}