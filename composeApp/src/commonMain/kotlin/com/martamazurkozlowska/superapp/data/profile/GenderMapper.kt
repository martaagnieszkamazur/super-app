package com.martamazurkozlowska.superapp.data.profile

import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel

fun GenderUiModel.toApiModel() =
    when (this) {
        GenderUiModel.Female -> GenderApiModel.Female
        GenderUiModel.Male   -> GenderApiModel.Male
    }

fun GenderApiModel.toUiModel() =
    when (this) {
        GenderApiModel.Female -> GenderUiModel.Female
        GenderApiModel.Male   -> GenderUiModel.Male
    }