package com.martamazurkozlowska.superapp.di

import com.martamazurkozlowska.superapp.storage.createDataStore
import org.koin.dsl.module

actual val dataStoreModule = module {
    single { createDataStore() }
}