package com.martamazurkozlowska.superapp.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class PersonalGoalStorageManager(
    private val dataStore: DataStore<Preferences>,
) {

    fun getPersonalGoalInKilos(): Flow<Float> = dataStore.data.map { it[key] ?: 0.0f }

    suspend fun setPersonalGoalInKilos(goal: Float) {
        runBlocking {
            dataStore.edit {
                it[key] = goal
            }
        }
    }

    companion object {
        private val key = floatPreferencesKey("personal_goal_kilos")
    }
}