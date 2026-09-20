package com.martamazurkozlowska.superapp.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class WeightStorageManager(
    private val dataStore: DataStore<Preferences>,
) {
    fun getWeight(): Flow<Double> = dataStore.data.map { it[key] ?: 0.0 }

    suspend fun setWeight(weight: Double) {
        runBlocking {
            dataStore.edit {
                it[key] = weight
            }
        }
    }

    companion object {
        private val key = doublePreferencesKey("weight")
    }
}