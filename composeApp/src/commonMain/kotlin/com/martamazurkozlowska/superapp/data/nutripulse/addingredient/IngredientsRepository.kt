package com.martamazurkozlowska.superapp.data.nutripulse.addingredient

import com.martamazurkozlowska.superapp.storage.nutripulse.IngredientsStorageManager

class IngredientsRepository(
    private val storageManager: IngredientsStorageManager,
) {
    suspend fun setIngredient(name: String, calories: Float) {
        storageManager.setIngredients(name, calories)
    }
}