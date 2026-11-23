package com.martamazurkozlowska.superapp.ui.components.test.radiobuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.stringResource

@Composable
fun TestRadioButtonsSelectorView(
    selectedButton: TestRadioButtonUiModel,
    onRadioButtonClick: (buttonType: TestRadioButtonUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .selectableGroup()
    ) {
        TestRadioButtonUiModel.entries.forEach { button ->
            TestRadioButtonOptionView(
                buttonType = button,
                isSelected = button == selectedButton,
                onRadioButtonClick = { onRadioButtonClick(button) }
            )
        }
    }
}

@Composable
private fun TestRadioButtonOptionView(
    buttonType: TestRadioButtonUiModel,
    isSelected: Boolean,
    onRadioButtonClick: (buttonType: TestRadioButtonUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(AppShapes.circle)
            .selectable(
                selected = isSelected,
                onClick = { onRadioButtonClick(buttonType) },
                role = Role.RadioButton,
            )
            .padding(6.dp)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = AppColors.blue600,
                unselectedColor = AppColors.gray300,
            )
        )

        Text(
            text = stringResource(buttonType.text),
            style = AppTypography.bodySmallBold,
            color = if (isSelected) AppColors.blue600 else AppColors.gray300,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}