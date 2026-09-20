package com.martamazurkozlowska.superapp.data.stepslist

import com.martamazurkozlowska.superapp.data.addsteps.StepsItemApiModel
import com.martamazurkozlowska.superapp.data.addsteps.toApiModel
import com.martamazurkozlowska.superapp.data.addsteps.toUiModel
import com.martamazurkozlowska.superapp.storage.StepsStorageManager
import com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps.StepsItemUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class StepsListRepository(
    private val storageManager: StepsStorageManager,
) {

    private val prettyJson = Json { prettyPrint = true }

    fun getStepsList(): Flow<List<StepsItemUiModel>> =
        storageManager.getAddedStepsJson().map {
            try {
                Json.decodeFromString<List<StepsItemApiModel>>(it).map { it.toUiModel() }
            } catch (exception: Exception) {
                exception.printStackTrace()
                emptyList()
            }
        }

    fun getStepsListJson(): Flow<String> = storageManager.getAddedStepsJson().map {
        try {
            Json.decodeFromString<List<StepsItemApiModel>>(it).toFormattedJson()
        } catch (exception: Exception) {
            exception.printStackTrace()
            "[]"
        }
    }

    private fun List<StepsItemApiModel>.toFormattedJson(): String =
        try {
            prettyJson.encodeToString(this)
        } catch (exception: Exception) {
            exception.printStackTrace()
            "[]"
        }

    suspend fun setStepsList(list: List<StepsItemUiModel>) {
        val apiModelList = list.map { it.toApiModel() }
        val json = Json.encodeToString(apiModelList)
        storageManager.setAddedStepsList(json)
    }

}