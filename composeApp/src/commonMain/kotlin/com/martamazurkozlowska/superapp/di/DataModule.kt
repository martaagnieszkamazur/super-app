package com.martamazurkozlowska.superapp.di

import com.martamazurkozlowska.superapp.data.addsteps.AddStepsRepository
import com.martamazurkozlowska.superapp.data.profile.GenderRepository
import com.martamazurkozlowska.superapp.data.profile.HeightRepository
import com.martamazurkozlowska.superapp.data.profile.PersonalGoalRepository
import com.martamazurkozlowska.superapp.data.profile.WeightRepository
import com.martamazurkozlowska.superapp.data.stepslist.StepsListRepository
import com.martamazurkozlowska.superapp.data.tasks.TasksRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::AddStepsRepository)
    factoryOf(::StepsListRepository)
    factoryOf(::GenderRepository)
    factoryOf(::PersonalGoalRepository)
    factoryOf(::HeightRepository)
    factoryOf(::WeightRepository)
    factoryOf(::TasksRepository)
}