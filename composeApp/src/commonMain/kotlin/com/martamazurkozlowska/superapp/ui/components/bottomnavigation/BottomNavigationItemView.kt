package com.martamazurkozlowska.superapp.ui.components.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import com.martamazurkozlowska.superapp.ui.theme.AppDimens
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomNavigationItemView(
    item: BottomNavigationItemUiModel,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val buttonColor = if (selected) AppColors.greenPrimary else AppColors.gray700
    val textColor = if (selected) AppColors.olive600 else AppColors.olive300

    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = buttonColor,
        ),
        onClick = onClick,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(item.icon),
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.size(AppDimens.iconSize)
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = stringResource(item.text),
                color = textColor,
                style = AppTypography.navigationItem
            )
        }
    }

}

@Preview
@Composable
private fun BottomNavigationItemViewPreview() = AppTheme {
    BottomNavigationItemView(
        item = BottomNavigationItemUiModel.Home,
        selected = true,
        onClick = {},
    )
}