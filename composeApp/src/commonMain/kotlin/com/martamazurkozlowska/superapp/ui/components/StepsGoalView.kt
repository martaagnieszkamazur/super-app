package com.martamazurkozlowska.superapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun StepsGoalView(
    stepsGoal: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {

                withStyle(style = SpanStyle(color = AppColors.text)) {
                    append(text = "Aby zrealizować swój cel, musisz wykonać około ")
                }

                withStyle(
                    style = SpanStyle(
                        color = AppColors.greenPrimary,
                        shadow = Shadow(color = AppColors.greenPrimary, blurRadius = 0.1f),
                        fontSize = 24.sp,
                    )
                ) {
                    append(text = "${stepsGoal/1000}k ")
                }

                withStyle(style = SpanStyle(color = AppColors.text)) {
                    append(text = "kroków.")
                }
            }
        },
        style = AppTypography.bodyMediumRegular,
        modifier = modifier
    )
}

@Preview
@Composable
private fun StepsGoalViewPreview() = AppTheme {
    StepsGoalView(
        stepsGoal = 1400000
    )
}