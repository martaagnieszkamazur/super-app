package com.martamazurkozlowska.superapp.app.stepscounter.journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.stepslist.StepsListRepository
import com.martamazurkozlowska.superapp.ui.components.journalitem.JournalStepsItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

class JournalViewModel(
    private val repository: StepsListRepository,
) : ViewModel() {

    private val stepsList = MutableStateFlow<List<JournalStepsItemUiModel>>(emptyList())
    val stepsListFlow = stepsList.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getStepsList().collect {
                stepsList.value = it.map { stepsItem ->
                    val instant = Instant.fromEpochMilliseconds(stepsItem.date!!) // TODO: Make date as non-nullable
                    val date = instant.toLocalDateTime(timeZone = TimeZone.currentSystemDefault()).date
                    JournalStepsItemUiModel(
                        stepsCount = stepsItem.stepsCount,
                        dateText = date.format(LocalDate.Formats.ISO)
                    )
                }
            }
        }
    }
}