package com.martamazurkozlowska.superapp.data.addsteps

import com.martamazurkozlowska.superapp.storage.StepsStorageManager
import com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps.StepsItemUiModel
import kotlinx.serialization.json.Json

class AddStepsRepository(
    private val storageManager: StepsStorageManager,
) {
    suspend fun addSteps(
        addedStepsList: List<StepsItemUiModel>,
        stepsCount: Int,
        date: Long?,
    ) {
        val existingSteps: List<StepsItemApiModel> = addedStepsList.map { it.toApiModel() }
        val newStepsCount = StepsItemApiModel(
            stepsCount = stepsCount,
            date = date,
        )
        val newStepsList = existingSteps.toMutableList()
        newStepsList.add(newStepsCount)
        val json = Json.encodeToString(newStepsList)
        storageManager.setAddedStepsList(json)
    }
}