package com.martamazurkozlowska.superapp.data.addsteps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StepsItemApiModel(

    @SerialName("steps_count")
    val stepsCount: Int,

    @SerialName("date")
    val date: Long?,
)
