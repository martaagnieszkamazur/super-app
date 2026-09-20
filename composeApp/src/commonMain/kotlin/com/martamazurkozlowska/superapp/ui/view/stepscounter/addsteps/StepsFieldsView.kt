package com.martamazurkozlowska.superapp.ui.view.stepscounter.addsteps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.ic_calendar
import superapp.composeapp.generated.resources.save
import superapp.composeapp.generated.resources.select_date
import superapp.composeapp.generated.resources.steps_count

@Composable
fun StepsFieldsView(
    stepsCount: TextFieldState,
    isStepsCountEmpty: Boolean,
    dateSelected: DatePickerState,
    isDatePickerEmpty: Boolean,
    selectedDateText: String?,
    onDateSelected: (Long?) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = AppColors.gray700, shape = AppShapes.textField)
            .padding(24.dp)
    ) {
        AddStepsTextFieldView(
            stepsCount = stepsCount,
            isError = isStepsCountEmpty,
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SelectDateView(
            dateSelected = dateSelected,
            isError = isDatePickerEmpty,
            selectedDateText = selectedDateText,
            onShowDatePickerClick = {},
            onDateSelected = onDateSelected,
        ) //TODO OBSŁUŻYĆ BRAK MOŻLIWOŚCI WPISANIA DATY Z PRZYSZŁOŚCI
    }
}

@Composable
private fun SelectDateView(
    dateSelected: DatePickerState,
    isError: Boolean,
    selectedDateText: String?,
    onDateSelected: (Long?) -> Unit,
    onShowDatePickerClick: () -> Unit,
) {
    Column {
        Text(
            text = stringResource(Res.string.select_date).uppercase(),
            style = AppTypography.navigationItem,
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        var showDatePicker by remember { mutableStateOf(false) }
        Button(
            onClick = {
                println("Click $showDatePicker")
                showDatePicker = true
                println("Show date picker $showDatePicker")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.itemBackground,
            ),
            shape = AppShapes.textField,
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = AppColors.olivePrimary, shape = AppShapes.textField)
        ) {
            if (selectedDateText == null) {
                Text(
                    text = stringResource(Res.string.select_date),
                    style = AppTypography.bodyMediumRegular,
                    color = AppColors.gray600,
                )
            } else {
                Text(
                    text = selectedDateText,
                    style = AppTypography.bodyMediumBlack,
                    color = AppColors.greenPrimary,
                )
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Icon(
                painter = painterResource(Res.drawable.ic_calendar),
                contentDescription = null,
                tint = AppColors.greenPrimary,
            )
        }

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = {
                    showDatePicker = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onDateSelected(dateSelected.selectedDateMillis)
                            showDatePicker = false
                        }
                    ) {
                        Text(
                            text = stringResource(Res.string.save),
                            style = AppTypography.bodyMediumRegular.copy(
                                color = AppColors.olivePrimary,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                },
                colors = DatePickerDefaults.colors(
                    containerColor = AppColors.gray700,
                )
            ) {
                DatePicker(
                    state = dateSelected,
                    colors = DatePickerDefaults.colors(
                        containerColor = AppColors.gray700,
                        titleContentColor = AppColors.olivePrimary,
                        headlineContentColor = AppColors.olivePrimary,
                        weekdayContentColor = AppColors.gray300,
                        dayContentColor = AppColors.text,
                        selectedDayContainerColor = AppColors.olivePrimary,
                        selectedDayContentColor = AppColors.gray700,
                        selectedYearContainerColor = AppColors.gray500,
                        navigationContentColor = AppColors.olivePrimary,
                        dividerColor = AppColors.olivePrimary,
                    )
                )
            }
        }

//        DatePicker(
//            state = dateSelected,
//            colors = DatePickerDefaults.colors(
//                containerColor = AppColors.gray700,
//                weekdayContentColor = AppColors.olivePrimary,
//
//                ),
//            title = {
//                DatePickerDefaults.DatePickerTitle(
//                    displayMode = DisplayMode.Input
//                )
//            }
//        )
    }
}

@Composable
private fun AddStepsTextFieldView(
    stepsCount: TextFieldState,
    isError: Boolean,
) {
    Column {
        Text(
            text = stringResource(Res.string.steps_count).uppercase(),
            style = AppTypography.navigationItem,
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TextField(
            state = stepsCount,
            shape = AppShapes.textField,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.text,
                focusedContainerColor = AppColors.gray700,
                unfocusedContainerColor = AppColors.gray700,
                focusedIndicatorColor = AppColors.text,
                unfocusedIndicatorColor = AppColors.gray100,
                cursorColor = AppColors.greenPrimary,
            ),
            textStyle = AppTypography.bodyMediumBlack,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = AppColors.olivePrimary, shape = AppShapes.textField)
        )
    }
}

@Preview
@Composable
private fun StepsFieldViewPreview() = AppTheme {
    StepsFieldsView(
        stepsCount = TextFieldState(),
        isStepsCountEmpty = false,
        dateSelected = rememberDatePickerState(),
        isDatePickerEmpty = false,
        selectedDateText = "",
        onDateSelected = {},
    )
}