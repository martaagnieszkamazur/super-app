package com.martamazurkozlowska.superapp.app.stepscounter.profile

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martamazurkozlowska.superapp.data.profile.GenderRepository
import com.martamazurkozlowska.superapp.data.profile.HeightRepository
import com.martamazurkozlowska.superapp.data.profile.PersonalGoalRepository
import com.martamazurkozlowska.superapp.data.profile.WeightRepository
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val personalGoalRepository: PersonalGoalRepository,
    private val genderRepository: GenderRepository,
    private val heightRepository: HeightRepository,
    private val weightRepository: WeightRepository,
) : ViewModel() {

    private val selectedGender = MutableStateFlow<GenderUiModel>(GenderUiModel.Female)
    val selectedGenderFlow = selectedGender.asStateFlow()

    val personalGoalTextState = TextFieldState()

    val heightTextState = TextFieldState()

    val weightTextState = TextFieldState()

    init {
        viewModelScope.launch {
            genderRepository.getSelectedGender().collect {
                println("gender $it")
                selectedGender.value = it
            }
        }

        viewModelScope.launch(Dispatchers.Main) {
            personalGoalRepository.getPersonalGoalInKilos().collect {
                println("goal $it")
                personalGoalTextState.setTextAndPlaceCursorAtEnd(text = it.toString())
            }
        }

        viewModelScope.launch {
            heightRepository.getHeight().collect {
                println("height $it")
                heightTextState.setTextAndPlaceCursorAtEnd(text = it.toString())
            }
        }

        viewModelScope.launch {
            weightRepository.getWeight().collect {
                println("weight $it")
                weightTextState.setTextAndPlaceCursorAtEnd(text = it.toString())
            }
        }
    }

    fun onGenderSelected(
        gender: GenderUiModel,
    ) {
        selectedGender.value = gender
    }

    fun onSaveProfile() {
        viewModelScope.launch {
            genderRepository.saveGender(gender = selectedGender.value)

            personalGoalRepository.savePersonalGoalInKilos(
                personalGoalInKilos = personalGoalTextState.text.toString().replace(oldChar = ',', newChar = '.').toDouble()
            )

            heightRepository.setHeight(
                height = heightTextState.text.toString().toInt()
            )

            weightRepository.setWeight(
                weight = weightTextState.text.toString().replace(oldChar = ',', newChar = '.').toDouble()
            )
        }
    }
}