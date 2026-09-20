package com.martamazurkozlowska.superapp.ui.components.journalitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import com.martamazurkozlowska.superapp.ui.view.stepscounter.profile.ProfileUiModel
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.steps

@Composable
fun JournalItemView(
    stepsItem: JournalStepsItemUiModel,
    profile: ProfileUiModel,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.itemBackground)
    ) {
        Text(
            text = stepsItem.dateText,
            style = AppTypography.bodySmallBold,
            color = if (stepsItem.stepsCount >= profile.dailyStepsGoal) AppColors.greenPrimary else AppColors.text,
        )

        Spacer(
            modifier = Modifier.width(24.dp)
        )

        Text(
            text = stepsItem.stepsCount.toString(),
            style = AppTypography.bodySmallLight,
            color = if (stepsItem.stepsCount >= profile.dailyStepsGoal) AppColors.greenPrimary else AppColors.text,
        )

        Text(
            text = stringResource(Res.string.steps),
            style = AppTypography.bodySmallLight,
            color = if (stepsItem.stepsCount >= profile.dailyStepsGoal) AppColors.greenPrimary else AppColors.text,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview
@Composable
private fun JournalItemViewPreview() = AppTheme {
    JournalItemView(
        stepsItem = JournalStepsItemUiModel(
            stepsCount = 6500,
            dateText = "10.01.2026"
        ),
        profile = ProfileUiModel(
            gender = GenderUiModel.Female,
            dailyStepsGoal = 6500,
            personalGoalInKilos = 0.0,
            stepLengthInCentimeters = 1,
            caloriesBurnt = 2,
        ),
    )
}