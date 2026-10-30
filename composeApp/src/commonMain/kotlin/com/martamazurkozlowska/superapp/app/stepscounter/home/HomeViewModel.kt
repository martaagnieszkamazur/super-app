package com.martamazurkozlowska.superapp.app.stepscounter.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.profile.GenderRepository
import com.martamazurkozlowska.superapp.data.profile.PersonalGoalRepository
import com.martamazurkozlowska.superapp.data.profile.WeightRepository
import com.martamazurkozlowska.superapp.data.stepslist.StepsListRepository
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlin.math.round

class HomeViewModel(
    private val repository: StepsListRepository,
    private val genderRepository: GenderRepository,
    private val personalGoalRepository: PersonalGoalRepository,
    private val weightRepository: WeightRepository,
) : ViewModel() {

    private val totalSteps: MutableStateFlow<Int> = MutableStateFlow(0)
    val totalStepsFlow = totalSteps.asStateFlow()

    private val caloriesSum: MutableStateFlow<Float> = MutableStateFlow(0.0f)
    val caloriesSumFlow = caloriesSum.asStateFlow()

    private val personalGoal: MutableStateFlow<Float> = MutableStateFlow(0.0f)
    val personalGoalFlow = personalGoal.asStateFlow()

    private val kilogramsCompleted: MutableStateFlow<Float> = MutableStateFlow(0.0f)
    val kilogramsCompletedFlow = kilogramsCompleted.asStateFlow()

    private val gender: MutableStateFlow<GenderUiModel> = MutableStateFlow(GenderUiModel.Female)
    val genderFlow = gender.asStateFlow()

    private val weight: MutableStateFlow<Float> = MutableStateFlow(0.0f)
    val weightFlow = weight.asStateFlow()

    private val kilometers = MutableStateFlow<Float>(0.0f)
    val kilometersFlow = kilometers.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getStepsList().collect { stepsList ->
                totalSteps.value = stepsList.sumOf { it.stepsCount }
            }
        }

        viewModelScope.launch {
            genderRepository.getSelectedGender().collect {
                gender.value = it
            }
        }

        viewModelScope.launch {
            weightRepository.getWeight().collect {
                weight.value = it
            }
        }

        viewModelScope.launch {
            combine(
                totalStepsFlow,
                genderFlow,
                weightFlow,
            ) { totalSteps, gender, weight ->
                kilometers.value = getKilometersSum(totalSteps = totalSteps, gender = gender)
                caloriesSum.value = getCaloriesSum(kilometers = kilometers.value, weight = weight)
                kilogramsCompleted.value = getKilosCompleted(caloriesSum = caloriesSum.value).also {
                    println("Kilos completed: $it")
                    println("Kilos goal: ${personalGoal.value}")
                }
            }.collect {}
        }
    }

    private fun getKilometersSum(totalSteps: Int, gender: GenderUiModel): Float {
        val stepLength = if (gender == GenderUiModel.Female) 66 else 80
        val totalKilometers = totalSteps * stepLength * 0.00001f
        return round(totalKilometers * 100.0f) / 100.0f
    }

    private fun getCaloriesSum(kilometers: Float, weight: Float): Float {
        println("km=$kilometers, weight=$weight")
        val timeInMinutes = kilometers * 12f
        return round(3.5f * 3.5f * weight * timeInMinutes / 200 * 10.0f) / 10.0f
    }

    private fun getStepsGoal(stepsCompleted: Int) {

    }

    private fun getKilosCompleted(caloriesSum: Float): Float {
        return caloriesSum / 7700f
    }
}