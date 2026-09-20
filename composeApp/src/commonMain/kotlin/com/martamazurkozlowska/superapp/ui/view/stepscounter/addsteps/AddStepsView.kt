package com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.buttons.StepsCounterPrimaryButton
import com.martamazurkozlowska.superapp.ui.components.navigationbar.NavigationBar
import com.martamazurkozlowska.superapp.ui.components.statusbar.StatusBar
import com.martamazurkozlowska.superapp.ui.components.topappbar.TopAppBarView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.add_steps
import superapp.composeapp.generated.resources.save

@Composable
fun AddStepsView(
    stepsCount: TextFieldState,
    isStepsCountEmpty: Boolean,
    selectedDateText: String?,
    onBackClick: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    onSaveStepsClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(24.dp)
    ) {
        TopAppBarView(
            title = stringResource(Res.string.add_steps),
            onBackClick = onBackClick,
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        StepsFieldsView(
            stepsCount = stepsCount,
            isStepsCountEmpty = isStepsCountEmpty,
            selectedDateText = selectedDateText,
            dateSelected = rememberDatePickerState(),
            isDatePickerEmpty = false,
            onDateSelected = onDateSelected,
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        StepsCounterPrimaryButton(
            text = stringResource(Res.string.save),
            leadingIcon = null,
            trailingIcon = null,
            onClick = onSaveStepsClick,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
private fun AddStepsViewPreview() = AppTheme {
    AddStepsView(
        stepsCount = TextFieldState(),
        isStepsCountEmpty = false,
        selectedDateText = "",
        onBackClick = {},
        onDateSelected = {},
        onSaveStepsClick = {},
    )
}