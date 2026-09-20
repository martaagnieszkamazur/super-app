package com.martamazurkozlowska.superapp.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class HeightStorageManager(
    private val dataStore: DataStore<Preferences>,
) {
    fun getHeight(): Flow<Int> = dataStore.data.map { it[key] ?: 0 }

    suspend fun setHeight(height: Int) {
        runBlocking {
            dataStore.edit {
                it[key] = height
            }
        }
    }

    companion object {
        private val key = intPreferencesKey("height")
    }
}