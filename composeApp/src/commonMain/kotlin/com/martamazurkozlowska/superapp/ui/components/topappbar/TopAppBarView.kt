package com.martamazurkozlowska.superapp.ui.components.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.modifier.clickableWithRoundedEffect
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppDimens
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.go_back
import superapp.composeapp.generated.resources.ic_back

@Composable
fun TopAppBarView(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(AppDimens.topAppBarHeight)
            .background(AppColors.background)
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_back),
            contentDescription = stringResource(Res.string.go_back),
            tint = AppColors.topAppBarIcon,
            modifier = Modifier
                .size(AppDimens.iconSize)
                .clickableWithRoundedEffect(
                    onClick = onBackClick,
                )
        )

        Spacer(
            modifier = Modifier.width(20.dp)
        )

        Text(
            text = title,
            style = AppTypography.h3Bold,
            modifier = Modifier
                .shadow(elevation = 16.dp)
        )
    }
}

@Preview
@Composable
private fun TopAppBarViewPreview() = AppTheme {
    TopAppBarView(
        title = "Dodaj kroki",
        onBackClick = {},
    )
}