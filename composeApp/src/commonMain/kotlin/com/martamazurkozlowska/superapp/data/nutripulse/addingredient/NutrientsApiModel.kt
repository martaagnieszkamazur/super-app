package com.martamazurkozlowska.superapp.data.nutripulse.addingredient

import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientItemUiModel
import com.martamazurkozlowska.superapp.ui.components.nutripulse.nutrients.NutrientTypeUiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutrientsApiModel(

    @SerialName("calories")
    val calories: NutrientItemApiModel,

    @SerialName("protein")
    val protein: NutrientItemApiModel,

    @SerialName("carbohydrates")
    val carbohydrates: NutrientItemApiModel,

    @SerialName("fats")
    val fats: NutrientItemApiModel,
) {
}

@Serializable
data class NutrientItemApiModel(

    @SerialName("type")
    val type: NutrientTypeUiModel,

    @SerialName("value")
    val value: Float,
)