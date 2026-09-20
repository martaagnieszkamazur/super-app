package com.martamazurkozlowska.superapp.ui.components.stepssummary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppDimens
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.ic_steps_sum
import superapp.composeapp.generated.resources.steps_sum

@Composable
fun StepsSummaryItemView(
    stepsSummaryItemUiModel: StepsSummaryItemUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.itemBackground, shape = AppShapes.item)
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(stepsSummaryItemUiModel.icon),
                contentDescription = stringResource(stepsSummaryItemUiModel.itemName),
                tint = stepsSummaryItemUiModel.tint,
                modifier = Modifier.size(AppDimens.iconSize)
            )

            Spacer(
                modifier = Modifier.width(6.dp)
            )

            Text(
                text = stringResource(stepsSummaryItemUiModel.itemName).uppercase(),
                style = AppTypography.bodySmallBold,
                color = stepsSummaryItemUiModel.tint,
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Row(
            verticalAlignment = Alignment.Bottom,

        ) {
            Text(
                text = stepsSummaryItemUiModel.value,
                style = AppTypography.bodyMediumBlack,
            )

            if (stepsSummaryItemUiModel.unit != null) {
                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Text(
                    text = stepsSummaryItemUiModel.unit,
                    style = AppTypography.bodySmallLight,
                    color = AppColors.olivePrimary,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun StepsSummaryItemViewPreview() = AppTheme {
    StepsSummaryItemView(
        stepsSummaryItemUiModel = StepsSummaryItemUiModel(
            itemName = Res.string.steps_sum,
            icon = Res.drawable.ic_steps_sum,
            value = "2000",
            unit = "kroków",
            tint = AppColors.bluePrimary
        ),
    )
}