package com.martamazurkozlowska.superapp.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.martamazurkozlowska.superapp.data.profile.GenderApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class GenderStorageManager(
    private val dataStore: DataStore<Preferences>,
) {

    fun getSelectedGender(): Flow<GenderApiModel> = dataStore.data.map {
        val string = it[key]
        if (string == null) {
            GenderApiModel.Female
        } else {
            GenderApiModel.from(string)
        }
    }

    suspend fun setSelectedGender(selectedGender: GenderApiModel) {
        runBlocking {
            dataStore.edit {
                it[key] = selectedGender.value
            }
        }
    }

    companion object Companion {
        private val key = stringPreferencesKey("selected_gender")
    }
}