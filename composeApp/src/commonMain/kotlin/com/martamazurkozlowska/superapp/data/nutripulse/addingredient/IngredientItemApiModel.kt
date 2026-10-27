package com.martamazurkozlowska.superapp.data.nutripulse.addingredient

import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientsUiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientItemApiModel(

    @SerialName("name")
    val ingredientName: String,

    @SerialName("category")
    val category: String,

    @SerialName("nutrients")
    val nutrients: NutrientsApiModel,
) {
}