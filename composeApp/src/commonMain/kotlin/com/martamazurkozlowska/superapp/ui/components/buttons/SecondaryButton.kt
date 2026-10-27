package com.martamazurkozlowska.superapp.ui.components.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun SecondaryButton(
    containerColor: Color,
    contentColor: Color,
    leadingIcon: Painter?,
    text: String?,
    trailingIcon: Painter?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        shape = AppShapes.button,
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row {
            if (leadingIcon != null) {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )
            }

            if (text != null) {
                Text(
                    text = text,
                    style = AppTypography.bodyMediumBold,
                    color = contentColor,
                )
            }

            if (trailingIcon != null) {
                Spacer(
                    modifier = Modifier.width(8.dp)
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
private fun SecondaryButtonPreview() = AppTheme {
    SecondaryButton(
        containerColor = AppColors.lime400,
        contentColor = AppColors.limeWhite,
        leadingIcon = null,
        text = "Zapisz",
        trailingIcon = null,
        onClick = {},
    )
}