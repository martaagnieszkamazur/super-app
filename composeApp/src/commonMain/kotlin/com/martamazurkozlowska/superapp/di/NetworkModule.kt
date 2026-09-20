package com.martamazurkozlowska.superapp.di

import com.martamazurkozlowska.superapp.data.network.createHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient() }
}
