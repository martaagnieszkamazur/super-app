package com.martamazurkozlowska.superapp.ui.components.goalcompletion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.steps_done

@Composable
fun GoalCompletionView(
    stepsCompleted: Int,
    kilosGoal: Float,
    kilosCompleted: Float,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = stepsCompleted.toString(),
                style = AppTypography.goalCount,
                autoSize = TextAutoSize.StepBased(maxFontSize = 35.sp),
                color = AppColors.bluePrimary,
            )

            Text(
                text = stringResource(Res.string.steps_done).uppercase(),
                style = AppTypography.bodySmallRegular,
                color = AppColors.olive300,
            )
        }

        CircularProgressIndicator(
            progress = { kilosCompleted / kilosGoal },
            strokeWidth = 20.dp,
            trackColor = AppColors.itemBackground,
            gapSize = (-20).dp,
            modifier = Modifier
                .size(240.dp)
        )
    }
}

@Composable
private fun Color.colorWithBrush(): Brush {
    return Brush.linearGradient(colors = listOf(AppColors.bluePrimary, AppColors.greenPrimary))
}

@Preview
@Composable
private fun GoalCompletionViewPreview() = AppTheme {
    GoalCompletionView(
        stepsCompleted = 1000,
        kilosGoal = 5.0f,
        kilosCompleted = 1.0f
    )
}