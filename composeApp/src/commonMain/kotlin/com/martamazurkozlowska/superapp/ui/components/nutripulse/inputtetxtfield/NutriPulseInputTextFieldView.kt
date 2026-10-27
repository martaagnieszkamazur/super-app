package com.martamazurkozlowska.superapp.ui.components.nutripulse.inputtetxtfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun NutriPulseInputTextFieldView(
    itemTitle: String,
    value: TextFieldState,
    suffix: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = itemTitle,
            style = AppTypography.bodySmallBold,
            color = AppColors.olive700,
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        OutlinedTextField(
            state = value,
            shape = AppShapes.textField,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = AppColors.gray700,
                unfocusedContainerColor = AppColors.limeWhite,
                focusedContainerColor = AppColors.lime50,
                cursorColor = AppColors.lime800,
                unfocusedBorderColor = AppColors.lime400,
                focusedBorderColor = AppColors.lime300,
            ),
            suffix = {
                if (suffix != null) {
                    Text(
                        text = suffix,
                        style = AppTypography.bodyMediumRegular,
                        color = AppColors.gray300,
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun NutriPulseInputTextFieldViewPreview() = AppTheme {
    NutriPulseInputTextFieldView(
        itemTitle = "Nazwa składnika",
        value = TextFieldState(),
        suffix = "nazwa",
    )
}