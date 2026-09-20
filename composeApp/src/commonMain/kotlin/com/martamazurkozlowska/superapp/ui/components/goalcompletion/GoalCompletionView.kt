package com.martamazurkozlowska.superapp.ui.components.goalcompletion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun GoalCompletionView(
    stepsGoal: Int,
    stepsCompleted: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        CircularProgressIndicator(
            progress = { stepsCompleted.toFloat() / stepsGoal },
            strokeWidth = 20.dp,
            trackColor = AppColors.itemBackground,
            gapSize = (-20).dp,
            modifier = Modifier
                .size(240.dp)
        )

        Text(
            text = stepsCompleted.toString(),
            style = AppTypography.h1Bold,
            color = AppColors.bluePrimary,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Composable
private fun Color.colorWithBrush(): Brush {
    return Brush.linearGradient(colors = listOf(AppColors.bluePrimary, AppColors.greenPrimary))
}

@Preview
@Composable
private fun GoalCompletionViewPreview() {
    GoalCompletionView(
        stepsGoal = 200000,
        stepsCompleted = 40000
    )
}