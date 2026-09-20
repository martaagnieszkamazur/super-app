package com.martamazurkozlowska.superapp.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import com.martamazurkozlowska.superapp.ui.theme.SuperAppsUiModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun PrimaryButton(
    appUiModel: SuperAppsUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.gray50,
            contentColor = appUiModel.color,
        ),
        shape = AppShapes.primaryButton,
        border = BorderStroke(5.dp, appUiModel.color),
        modifier = modifier
    ) {
        Text(
            text = stringResource(appUiModel.appName),
            style = AppTypography.h2Bold,
            color = appUiModel.color,
            modifier = Modifier
                .padding(12.dp)
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() = AppTheme {
    PrimaryButton(
        appUiModel = SuperAppsUiModel.StepsCounter,
        onClick = {},
    )
}