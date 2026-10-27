package com.martamazurkozlowska.superapp.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import org.jetbrains.compose.resources.painterResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.ic_ingredient

@Composable
fun TertiaryButton(
    contentColor: Color,
    containerColor: Color,
    borderColor: Color,
    leadingIcon: Painter?,
    text: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        shape = AppShapes.button,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
            containerColor = containerColor,
        ),
        border = BorderStroke(width = 2.dp, color = borderColor),
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (leadingIcon != null) {
            Icon(
                painter = leadingIcon,
                contentDescription = null,
                tint = contentColor,
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
    }
}

@Preview
@Composable
private fun TertiaryButtonPreview() = AppTheme {
    TertiaryButton(
        contentColor = AppColors.lime400,
        containerColor = AppColors.limeWhite,
        borderColor = AppColors.lime400,
        leadingIcon = painterResource(Res.drawable.ic_ingredient),
        text = "Moja biblioteka",
        onClick = {},
    )
}