package com.martamazurkozlowska.superapp.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StepsStorageManager(
    private val dataStore: DataStore<Preferences>,
) {

    fun getAddedStepsJson(): Flow<String> = dataStore.data.map { it[key] ?: "[]" }

    suspend fun setAddedStepsList(json: String) {
        dataStore.edit {
            it[key] = json
        }
    }

    companion object Companion {
        private val key = stringPreferencesKey("added_steps")
    }
}