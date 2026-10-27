package com.martamazurkozlowska.superapp.data.stepslist

import com.martamazurkozlowska.superapp.data.addsteps.StepsItemApiModel
import com.martamazurkozlowska.superapp.data.addsteps.toUiModel
import com.martamazurkozlowska.superapp.storage.StepsStorageManager
import com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps.StepsItemUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class StepsListRepository(
    private val storageManager: StepsStorageManager,
) {
    fun getStepsList(): Flow<List<StepsItemUiModel>> =
        storageManager.getAddedStepsJson().map {
            try {
                Json.decodeFromString<List<StepsItemApiModel>>(it).map { it.toUiModel() }
            } catch (exception: Exception) {
                exception.printStackTrace()
                emptyList()
            }
        }
}