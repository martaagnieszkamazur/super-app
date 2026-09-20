package com.martamazurkozlowska.superapp.app.stepscounter.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.profile.GenderRepository
import com.martamazurkozlowska.superapp.data.stepslist.StepsListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: StepsListRepository,
    private val genderRepository: GenderRepository,
) : ViewModel() {

    private val totalSteps: MutableStateFlow<Int> = MutableStateFlow(0)
    val totalStepsFlow = totalSteps.asStateFlow()

    private val caloriesSum: MutableStateFlow<Int> = MutableStateFlow(0)
    val caloriesSumFlow = caloriesSum.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getStepsList().collect { stepsList ->
                totalSteps.value = stepsList.sumOf { it.stepsCount }
            }
        }
    }
}