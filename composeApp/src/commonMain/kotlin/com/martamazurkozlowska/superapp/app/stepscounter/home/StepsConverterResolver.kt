package com.martamazurkozlowska.superapp.app.stepscounter.home

import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import kotlin.math.round

class StepsConverterResolver {

    fun getKilometersSum(totalSteps: Int, gender: GenderUiModel): Float {
        val stepLength = if (gender == GenderUiModel.Female) 66 else 80
        val totalKilometers = totalSteps * stepLength * 0.00001f
        return round(totalKilometers * 100.0f) / 100.0f
    }
}