package com.martamazurkozlowska.superapp.ui.components.nutripulse.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun NutriPulseBottomNavigationItemView(
    navigationItemUiModel: NutriPulseBottomNavigationUiModel,
    selected: Boolean,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val buttonColor = if (selected) AppColors.limePrimary else AppColors.nutriBackgroud
    val textColor = if (selected) AppColors.lime50 else AppColors.lime600

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor,
        ),
        contentPadding = PaddingValues(0.dp),
        onClick = onItemClick,
        modifier = modifier
            .background(color = buttonColor, shape = AppShapes.item)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
        ) {
            Icon(
                painter = painterResource(navigationItemUiModel.icon),
                contentDescription = null,
                tint = textColor,
            )

            Text(
                text = stringResource(navigationItemUiModel.itemName),
                style = AppTypography.nutriPulseNavigationItem,
                color = textColor,
//                maxLines = 1,
//                fontSize = 8.sp,
            )
        }
    }
}

@Preview
@Composable
private fun NutriPulseBottomNavigationItemViewPreview() {
    NutriPulseBottomNavigationItemView(
        navigationItemUiModel = NutriPulseBottomNavigationUiModel.Home,
        selected = true,
        onItemClick = {},
    )
}