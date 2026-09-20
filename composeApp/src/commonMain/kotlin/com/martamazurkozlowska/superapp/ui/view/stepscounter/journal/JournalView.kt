package com.martamazurkozlowska.superapp.ui.view.stepscounter.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.journalitem.JournalItemView
import com.martamazurkozlowska.superapp.ui.components.journalitem.JournalStepsItemUiModel
import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import com.martamazurkozlowska.superapp.ui.components.topappbar.TopAppBarView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import com.martamazurkozlowska.superapp.ui.view.stepscounter.profile.ProfileUiModel
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.journal

@Composable
fun JournalView(
    items: List<JournalStepsItemUiModel>,
    profileUiModel: ProfileUiModel,
    onBackCLick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(16.dp)
    ) {
        TopAppBarView(
            title = stringResource(Res.string.journal),
            onBackClick = onBackCLick,
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AppColors.gray700, shape = AppShapes.item)
                .padding(12.dp)
                .weight(1f)
        ) {
            Text(
                text = "Historia wpisów",
                style = AppTypography.bodySmallLight,
                color = AppColors.olivePrimary,
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = AppColors.gray700, shape = AppShapes.item)
            ) {
                items(items = items) {
                    JournalItemView(
                        stepsItem = it,
                        profile = profileUiModel,
                    )
                } //TODO DODAĆ SORTOWANIE PO DACIE WPISU
            }
        }
    }
}

@Preview
@Composable
private fun JournalViewPreview() = AppTheme {
    JournalView(
        items = listOf(
            JournalStepsItemUiModel(
                stepsCount = 5000,
                dateText = "10.01.2026",
            ),
            JournalStepsItemUiModel(
                stepsCount = 7500,
                dateText = "11.01.2026",
            )
        ),
        profileUiModel = ProfileUiModel(
            gender = GenderUiModel.Female,
            dailyStepsGoal = 6000,
            personalGoalInKilos = 5.0,
            stepLengthInCentimeters = 75,
            caloriesBurnt = 100,
        ),
        onBackCLick = {},
    )
}