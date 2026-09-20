package com.martamazurkozlowska.superapp.data.profile

enum class GenderApiModel(
    val value: String,
) {
    Female(
        value = "female",
    ),
    Male(
        value = "male",
    ),
    ;

    companion object {
        fun from(gender: String): GenderApiModel {
            return when (gender) {
                "female" -> GenderApiModel.Female
                "male"   -> GenderApiModel.Male
                else     -> GenderApiModel.Female
            }
        }
    }
}