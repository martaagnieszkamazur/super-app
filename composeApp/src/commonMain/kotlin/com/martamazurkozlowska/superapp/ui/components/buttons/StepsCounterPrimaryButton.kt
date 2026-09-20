package com.martamazurkozlowska.superapp.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun StepsCounterPrimaryButton(
    text: String?,
    leadingIcon: Painter?,
    trailingIcon: Painter?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.greenPrimary,
            contentColor = AppColors.olive600,
        ),
        onClick = onClick,
        shape = AppShapes.stepsCounterPrimaryButton,
        border = BorderStroke(width = 1.dp, color = AppColors.green100),
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 16.dp, ambientColor = AppColors.greenPrimary, spotColor = AppColors.greenPrimary)
    ) {
        Row {
            if (leadingIcon != null) {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )
            }

            if (text != null) {
                Text(
                    text = text,
                    style = AppTypography.primaryButton,
                    modifier = Modifier.padding(12.dp)
                )
            }

            if (trailingIcon != null) {
                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                Icon(
                    painter = trailingIcon,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview
@Composable
private fun StepsCounterPrimaryButtonPreview() = AppTheme {
    StepsCounterPrimaryButton(
        text = "Dodaj kroki",
        leadingIcon = null,
        trailingIcon = null,
        onClick = {},
    )
}