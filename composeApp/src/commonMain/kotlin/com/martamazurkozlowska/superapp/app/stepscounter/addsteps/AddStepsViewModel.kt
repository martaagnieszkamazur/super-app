package com.martamazurkozlowska.superapp.app.stepscounter.addsteps

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.addsteps.AddStepsRepository
import com.martamazurkozlowska.superapp.data.stepslist.StepsListRepository
import com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps.StepsItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

class AddStepsViewModel(
    private val repository: AddStepsRepository,
    private val stepsListRepository: StepsListRepository,
) : ViewModel() {
    val stepsCountTextState = TextFieldState()

    private val selectedDateInMillis = MutableStateFlow<Long?>(null)
    val selectedDateInMillisFlow = selectedDateInMillis.asStateFlow()

    private val selectedDateText = MutableStateFlow<String?>(null)
    val selectedDateTextFlow = selectedDateText.asStateFlow()

    private val stepsListFlow: StateFlow<List<StepsItemUiModel>> = stepsListRepository.getStepsList().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList(),
    )

    init {
        viewModelScope.launch {
            selectedDateInMillisFlow.collect {
                if (it == null) {
                    selectedDateText.value = null
                } else {
                    val instant = Instant.fromEpochMilliseconds(it)
                    val date = instant.toLocalDateTime(timeZone = TimeZone.currentSystemDefault()).date
                    selectedDateText.value = date.format(LocalDate.Formats.ISO)
                }
            }
        }
    }

    fun onDateSelected(selectedDateMillis: Long?) {
        selectedDateInMillis.value = selectedDateMillis
    }

    fun onSaveStepsClick() {
        viewModelScope.launch {
            repository.addSteps(
                addedStepsList = stepsListFlow.value,
                stepsCount = stepsCountTextState.text.toString().toInt(),
                date = selectedDateInMillis.value
            )
        }
    }
}