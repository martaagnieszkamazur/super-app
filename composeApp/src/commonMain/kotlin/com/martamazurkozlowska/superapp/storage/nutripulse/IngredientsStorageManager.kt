package com.martamazurkozlowska.superapp.storage.nutripulse

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.martamazurkozlowska.superapp.ui.components.nutripulse.ingredientitem.IngredientItemUiModel
import kotlinx.coroutines.flow.Flow

class IngredientsStorageManager(
    private val dataStore: DataStore<Preferences>,
) {
    fun getIngredientsList(): Flow<List<IngredientItemUiModel>> {
        TODO()
    }

    suspend fun setIngredients(name: String, calories: Float) {
        dataStore.edit {
            it[nameKey] = name
            it[caloriesKey] = calories
        }
    }

    companion object {
        private val nameKey = stringPreferencesKey("name")
        private val caloriesKey = floatPreferencesKey("calories")
    }
}