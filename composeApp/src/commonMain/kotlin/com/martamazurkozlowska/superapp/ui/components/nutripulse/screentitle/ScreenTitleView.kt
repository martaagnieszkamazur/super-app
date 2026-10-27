package com.martamazurkozlowska.superapp.ui.components.nutripulse.screentitle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun ScreenTitleView(
    text1: String?,
    text2: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (text1 != null) {
            Text(
                text = text1.uppercase(),
                style = AppTypography.bodySmallBold,
                color = AppColors.nutriText,
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }

        if (text2 != null) {
            Text(
                text = text2,
                style = AppTypography.h3Regular,
                color = AppColors.gray700,
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ScreenTitleViewPreview() = AppTheme {
    ScreenTitleView(
        text1 = "kreator nowego składnika",
        text2 = "Wprowadź wartości odżywcze"
    )
}