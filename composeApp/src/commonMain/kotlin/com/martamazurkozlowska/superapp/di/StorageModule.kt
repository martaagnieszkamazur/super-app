package com.martamazurkozlowska.superapp.di

import com.martamazurkozlowska.superapp.storage.GenderStorageManager
import com.martamazurkozlowska.superapp.storage.HeightStorageManager
import com.martamazurkozlowska.superapp.storage.PersonalGoalStorageManager
import com.martamazurkozlowska.superapp.storage.StepsStorageManager
import com.martamazurkozlowska.superapp.storage.WeightStorageManager
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

expect val dataStoreModule: Module

val storageModule = module {
    singleOf(::StepsStorageManager)
    singleOf(::GenderStorageManager)
    singleOf(::PersonalGoalStorageManager)
    singleOf(::HeightStorageManager)
    singleOf(::WeightStorageManager)
}