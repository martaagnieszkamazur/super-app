package com.martamazurkozlowska.superapp.di

import com.martamazurkozlowska.superapp.app.main.MainScreenViewModel
import com.martamazurkozlowska.superapp.app.main.MainViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.addingredient.AddIngredientViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.addmeal.AddMealViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.home.NutriPulseHomeViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.ingredientlibrary.IngredientsLibraryViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.journal.NutriPulseJournalViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.navigation.NutriPulseNavigationViewModel
import com.martamazurkozlowska.superapp.app.nutripulse.profile.NutriPulseProfileViewModel
import com.martamazurkozlowska.superapp.app.stepscounter.addsteps.AddStepsViewModel
import com.martamazurkozlowska.superapp.app.stepscounter.home.HomeViewModel
import com.martamazurkozlowska.superapp.app.stepscounter.journal.JournalViewModel
import com.martamazurkozlowska.superapp.app.stepscounter.navigation.NavigationViewModel
import com.martamazurkozlowska.superapp.app.stepscounter.profile.ProfileViewModel
import com.martamazurkozlowska.superapp.app.test.TestViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::NavigationViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::JournalViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::AddStepsViewModel)
    viewModelOf(::TestViewModel)
    viewModelOf(::NutriPulseNavigationViewModel)
    viewModelOf(::NutriPulseHomeViewModel)
    viewModelOf(::AddMealViewModel)
    viewModelOf(::AddIngredientViewModel)
    viewModelOf(::NutriPulseJournalViewModel)
    viewModelOf(::NutriPulseProfileViewModel)
    viewModelOf(::IngredientsLibraryViewModel)
    viewModelOf(::MainViewModel)
}