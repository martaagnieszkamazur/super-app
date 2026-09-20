package com.martamazurkozlowska.superapp.ui.components.sexitem

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun SexItemView(
    buttonChecked: Boolean,
    onButtonCheckClick:()-> Unit,
    sex: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        RadioButton(
            selected = buttonChecked,
            onClick = onButtonCheckClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = AppColors.greenPrimary,
                unselectedColor = AppColors.gray500,
            ),
        )

        Text(
            text = sex,
            style = AppTypography.bodyMediumRegular,
            color = AppColors.olivePrimary,
        )
    }
}

@Preview
@Composable
private fun SexItemViewPreview() = AppTheme {
    SexItemView(
        buttonChecked = true,
        onButtonCheckClick = {},
        sex = "Kobieta"
    )
}