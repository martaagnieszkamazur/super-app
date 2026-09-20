package com.martamazurkozlowska.superapp.ui.view.stepscounter.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.buttons.StepsCounterPrimaryButton
import com.martamazurkozlowska.superapp.ui.components.profileitem.ProfileItemView
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import com.martamazurkozlowska.superapp.ui.components.topappbar.TopAppBarView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.centimeters
import superapp.composeapp.generated.resources.height
import superapp.composeapp.generated.resources.kg
import superapp.composeapp.generated.resources.profile
import superapp.composeapp.generated.resources.save
import superapp.composeapp.generated.resources.set_your_goal
import superapp.composeapp.generated.resources.sex
import superapp.composeapp.generated.resources.weight

@Composable
fun ProfileView(
    selectedGender: GenderUiModel,
    personalGoal: TextFieldState,
    isPersonalGoalEmpty: Boolean,
    height: TextFieldState,
    isHeightFieldEmpty: Boolean,
    weight: TextFieldState,
    isWeightFieldEmpty: Boolean,
    onBackClick: () -> Unit,
    onGenderSelected: (gender: GenderUiModel) -> Unit,
    onSaveProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(16.dp)
    ) {
        TopAppBarView(
            title = stringResource(Res.string.profile),
            onBackClick = onBackClick
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AppColors.itemBackground, shape = AppShapes.item)
                .padding(24.dp)
        ) {
            Text(
                text = stringResource(Res.string.sex).uppercase(),
                style = AppTypography.bodySmallLight,
                color = AppColors.olivePrimary,
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            GenderSelectorView(
                selectedGender = selectedGender,
                onGenderSelected = onGenderSelected,
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SetGoalView(
            personalGoal = personalGoal,
            isError = isPersonalGoalEmpty,
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

SetPersonalDimensView(
    height = height,
    isHeightFieldEmpty = isHeightFieldEmpty,
    weight = weight,
    isWeightFieldEmpty = isWeightFieldEmpty,
)

        Spacer(
            modifier = Modifier.weight(1f)
        )

        StepsCounterPrimaryButton(
            text = stringResource(Res.string.save),
            leadingIcon = null,
            trailingIcon = null,
            onClick = onSaveProfileClick,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
private fun GenderSelectorView(
    selectedGender: GenderUiModel,
    onGenderSelected: (gender: GenderUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.selectableGroup()
    ) {
        GenderUiModel.entries.toList().forEach { gender ->
            GenderOptionView(
                gender = gender,
                isSelected = gender == selectedGender,
                onGenderSelected = onGenderSelected,
            )
        }
    }
}

@Composable
private fun GenderOptionView(
    gender: GenderUiModel,
    isSelected: Boolean,
    onGenderSelected: (gender: GenderUiModel) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(shape = AppShapes.circle)
            .selectable(
                selected = isSelected,
                onClick = { onGenderSelected(gender) },
                role = Role.RadioButton,
            )
            .padding(6.dp)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = AppColors.greenPrimary,
                unselectedColor = AppColors.gray400,
            )
        )

        Text(
            text = stringResource(gender.titleRes),
            style = AppTypography.bodySmallBold,
            color = if (isSelected) AppColors.text else AppColors.gray200,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun SetGoalView(
    personalGoal: TextFieldState,
    isError: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = AppColors.itemBackground, shape = AppShapes.item)
            .padding(24.dp)
    ) {
        Text(
            text = stringResource(Res.string.set_your_goal).uppercase(),
            style = AppTypography.bodySmallLight,
            color = AppColors.olivePrimary,
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TextField(
            state = personalGoal,
            shape = AppShapes.textField,
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.text,
                focusedContainerColor = AppColors.gray700,
                unfocusedContainerColor = AppColors.gray700,
                focusedIndicatorColor = AppColors.text,
                unfocusedIndicatorColor = AppColors.gray100,
                cursorColor = AppColors.greenPrimary,
            ),
            suffix = {
                Text(
                    text = stringResource(Res.string.kg),
                    style = AppTypography.bodyMediumRegular,
                    color = AppColors.gray500,
                )
            },
            textStyle = AppTypography.bodyMediumBlack,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
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

@Composable
private fun SetPersonalDimensView(
    height: TextFieldState,
    isHeightFieldEmpty: Boolean,
    weight: TextFieldState,
    isWeightFieldEmpty: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = AppColors.itemBackground, shape = AppShapes.item)
            .padding(24.dp)
    ) {
        ProfileItemView(
            title = stringResource(Res.string.height),
            textFieldState = height,
            textFieldSuffix = stringResource(Res.string.centimeters),
            isError = isHeightFieldEmpty,
            modifier = Modifier.weight(1f)
        )

        Spacer(
            modifier = Modifier.width(24.dp)
        )

        ProfileItemView(
            title = stringResource(Res.string.weight),
            textFieldState = weight,
            textFieldSuffix = stringResource(Res.string.kg),
            isError = isWeightFieldEmpty,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
private fun ProfileViewPreview() = AppTheme {
    ProfileView(
        selectedGender = GenderUiModel.Female,
        personalGoal = TextFieldState(),
        isPersonalGoalEmpty = false,
        height = TextFieldState(),
        isHeightFieldEmpty = false,
        weight = TextFieldState(),
        isWeightFieldEmpty = false,
        onBackClick = {},
        onGenderSelected = {},
        onSaveProfileClick = {},
    )
}