package com.martamazurkozlowska.superapp.ui.view.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.buttons.PrimaryButton
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import com.martamazurkozlowska.superapp.ui.theme.SuperAppsUiModel

@Composable
fun MainView(
    onStepsCounterAppClick: () -> Unit,
    onTestClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Super App",
                style = AppTypography.h1Bold,
                color = AppColors.gray900,
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            PrimaryButton(
                appUiModel = SuperAppsUiModel.StepsCounter,
                onClick = onStepsCounterAppClick
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            PrimaryButton(
                appUiModel = SuperAppsUiModel.Test,
                onClick = onTestClick,
            )
        }
    }

}

@Preview
@Composable
private fun MainViewPreview() = AppTheme {
    MainView(
        onStepsCounterAppClick = {},
        onTestClick = {},
    )
}