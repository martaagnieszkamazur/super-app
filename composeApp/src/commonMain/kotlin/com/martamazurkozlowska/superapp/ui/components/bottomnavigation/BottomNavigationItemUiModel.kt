package com.martamazurkozlowska.superapp.ui.components.bottomnavigation

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.ic_home
import superapp.composeapp.generated.resources.ic_journal
import superapp.composeapp.generated.resources.ic_profile
import superapp.composeapp.generated.resources.journal
import superapp.composeapp.generated.resources.main
import superapp.composeapp.generated.resources.profile

enum class BottomNavigationItemUiModel(
    val icon: DrawableResource,
    val text: StringResource,
) {
    Home(
        icon = Res.drawable.ic_home,
        text = Res.string.main,
    ),

    Journal(
        icon = Res.drawable.ic_journal,
        text = Res.string.journal,
    ),

    Profile(
        icon = Res.drawable.ic_profile,
        text = Res.string.profile
    )
}