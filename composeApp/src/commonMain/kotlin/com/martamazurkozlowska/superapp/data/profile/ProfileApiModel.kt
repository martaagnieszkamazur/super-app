package com.martamazurkozlowska.superapp.data.profile

class ProfileApiModel(
    val gender: GenderApiModel,
    val dailyStepsGoal: Int,
    val personalGoalInKilos: Double,
    val stepLengthInCentimeters: Int,
    val caloriesBurnt: Int,
) {
}