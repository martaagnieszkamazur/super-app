package com.martamazurkozlowska.superapp.app.stepscounter.home

import kotlin.math.round

class CaloriesResolver {

    fun getCaloriesSum(kilometers: Float, weight: Float): Float {
        val timeInMinutes = kilometers * 12f
        return round(3.5f * 3.5f * weight * timeInMinutes / 200 * 10.0f) / 10.0f
    }
}