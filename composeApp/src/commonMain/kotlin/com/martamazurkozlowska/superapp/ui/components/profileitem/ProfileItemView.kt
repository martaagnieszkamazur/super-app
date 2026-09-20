package com.martamazurkozlowska.superapp.ui.components.profileitem

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun ProfileItemView(
    title: String,
    textFieldState: TextFieldState,
    textFieldSuffix: String?,
    isError: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title.uppercase(),
            style = AppTypography.bodySmallLight,
            color = AppColors.olivePrimary
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TextField(
            state = textFieldState,
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
                if (textFieldSuffix != null) {
                    Text(
                        text = textFieldSuffix,
                        style = AppTypography.bodyMediumRegular,
                        color = AppColors.gray500,
                    )
                }
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

@Preview
@Composable
private fun ProfileItemViewPreview()= AppTheme {
    ProfileItemView(
        title = "WAGA",
        textFieldState = TextFieldState(),
        textFieldSuffix = "kg",
        isError = false,
    )
}