package com.martamazurkozlowska.superapp.ui.components.nutripulse.bottomnavigation

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.add_ingredient
import superapp.composeapp.generated.resources.add_meal
import superapp.composeapp.generated.resources.add_steps
import superapp.composeapp.generated.resources.ic_chart
import superapp.composeapp.generated.resources.ic_ingredient
import superapp.composeapp.generated.resources.ic_journal
import superapp.composeapp.generated.resources.ic_meal
import superapp.composeapp.generated.resources.ic_profile
import superapp.composeapp.generated.resources.journal
import superapp.composeapp.generated.resources.main
import superapp.composeapp.generated.resources.profile

enum class NutriPulseBottomNavigationUiModel(
    val itemName: StringResource,
    val icon: DrawableResource,
) {
    Home(
        itemName = Res.string.main,
        icon = Res.drawable.ic_chart,
    ),

    AddMeal(
        itemName = Res.string.add_meal,
        icon = Res.drawable.ic_meal,
    ),

    AddIngredient(
        itemName = Res.string.add_ingredient,
        icon = Res.drawable.ic_ingredient,
    ),

    Journal(
        itemName = Res.string.journal,
        icon = Res.drawable.ic_journal,
    ),

    Profile(
        itemName = Res.string.profile,
        icon = Res.drawable.ic_profile,
    ),

}