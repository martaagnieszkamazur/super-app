package com.martamazurkozlowska.superapp.ui.view.stepscounter.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.buttons.StepsCounterPrimaryButton
import com.martamazurkozlowska.superapp.ui.components.stepssummary.StepsSummaryItemUiModel
import com.martamazurkozlowska.superapp.ui.components.stepssummary.StepsSummaryItemView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.add_steps
import superapp.composeapp.generated.resources.calories_sum
import superapp.composeapp.generated.resources.ic_burnt_calories
import superapp.composeapp.generated.resources.ic_distance
import superapp.composeapp.generated.resources.ic_steps_sum
import superapp.composeapp.generated.resources.km_sum
import superapp.composeapp.generated.resources.steps_sum

@Composable
fun HomeView(
    stepsSumValue: String,
    caloriesSumValue: String,
    kilometersSumValue: String,
    onAddStepsClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(16.dp)
    ) {
        StepsSummaryItemView(
            StepsSummaryItemUiModel(
                itemName = Res.string.steps_sum,
                icon = Res.drawable.ic_steps_sum,
                value = stepsSumValue,
                unit = null,
                tint = AppColors.bluePrimary,
            )
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            StepsSummaryItemView(
                StepsSummaryItemUiModel(
                    itemName = Res.string.calories_sum,
                    icon = Res.drawable.ic_burnt_calories,
                    value = caloriesSumValue,
                    unit = "kcal",
                    tint = AppColors.greenPrimary,
                ),
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            StepsSummaryItemView(
                StepsSummaryItemUiModel(
                    itemName = Res.string.km_sum,
                    icon = Res.drawable.ic_distance,
                    value = kilometersSumValue,
                    unit = "km",
                    tint = AppColors.bluePrimary,
                ),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        StepsCounterPrimaryButton(
            text = stringResource(Res.string.add_steps),
            leadingIcon = null,
            trailingIcon = null,
            onClick = onAddStepsClick,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
private fun HomeViewPreview() = AppTheme {
    HomeView(
        stepsSumValue = "2000",
        caloriesSumValue = "750",
        kilometersSumValue = "6.4",
        onAddStepsClick = {},
    )
}