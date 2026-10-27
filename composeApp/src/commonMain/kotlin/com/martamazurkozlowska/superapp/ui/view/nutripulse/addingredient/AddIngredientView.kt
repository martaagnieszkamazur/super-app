package com.martamazurkozlowska.superapp.ui.view.nutripulse.addingredient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.components.buttons.SecondaryButton
import com.martamazurkozlowska.superapp.ui.components.buttons.TertiaryButton
import com.martamazurkozlowska.superapp.ui.components.nutripulse.inputtetxtfield.NutriPulseInputTextFieldView
import com.martamazurkozlowska.superapp.ui.components.nutripulse.screentitle.ScreenTitleView
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppShapes
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.calories
import superapp.composeapp.generated.resources.create_new_ingredient
import superapp.composeapp.generated.resources.ic_add_bookmark
import superapp.composeapp.generated.resources.ic_burnt_calories
import superapp.composeapp.generated.resources.ic_ingredient
import superapp.composeapp.generated.resources.ingredient_name
import superapp.composeapp.generated.resources.kcal
import superapp.composeapp.generated.resources.put_nutrients_values
import superapp.composeapp.generated.resources.save_in_my_library

@Composable
fun AddIngredientView(
    newIngredientNameValue: TextFieldState,
    caloriesValue: TextFieldState,
    onSaveClick: () -> Unit,
    onIngredientsLibraryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.nutriBackgroud)
            .padding(24.dp)
    ) {
        ScreenTitleView(
            text1 = stringResource(Res.string.create_new_ingredient),
            text2 = stringResource(Res.string.put_nutrients_values),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AppColors.nutriItemBackground, shape = AppShapes.item)
                .padding(12.dp)
        ) {
            NutriPulseInputTextFieldView(
                itemTitle = stringResource(Res.string.ingredient_name),
                value = newIngredientNameValue,
                suffix = null,
            )

            Spacer(
                modifier = Modifier.height(36.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_burnt_calories),
                    contentDescription = null,
                    tint = AppColors.limePrimary,
                    modifier = Modifier.size(36.dp)
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Text(
                    text = "Wartości energetyczne w przeliczeniu na 100g produktu",
                    style = AppTypography.bodySmallRegular,
                    color = AppColors.gray700
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            NutriPulseInputTextFieldView(
                itemTitle = stringResource(Res.string.calories),
                value = caloriesValue,
                suffix = stringResource(Res.string.kcal)
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        BottomButtonsView(
            onSaveClick = onSaveClick,
            onIngredientsLibraryClick = onIngredientsLibraryClick,
        )
    }
}

@Composable
private fun BottomButtonsView(
    onSaveClick: () -> Unit,
    onIngredientsLibraryClick: () -> Unit,
) {
    SecondaryButton(
        containerColor = AppColors.nutriButton,
        contentColor = AppColors.limeWhite,
        leadingIcon = painterResource(Res.drawable.ic_add_bookmark),
        text = stringResource(Res.string.save_in_my_library),
        trailingIcon = null,
        onClick = onSaveClick,
    )

    Spacer(
        modifier = Modifier.height(8.dp)
    )

    TertiaryButton(
        contentColor = AppColors.nutriButton,
        containerColor = AppColors.nutriItemBackground,
        borderColor = AppColors.nutriButton,
        leadingIcon = painterResource(Res.drawable.ic_ingredient),
        text = "Moja biblioteka",
        onClick = onIngredientsLibraryClick,
    )
}

@Preview
@Composable
private fun AddIngredientViewPreview() = AppTheme {
    AddIngredientView(
        newIngredientNameValue = TextFieldState(),
        caloriesValue = TextFieldState(),
        onSaveClick = {},
        onIngredientsLibraryClick = {},
    )
}