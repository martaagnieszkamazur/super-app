package com.martamazurkozlowska.superapp.di

import com.martamazurkozlowska.superapp.data.network.AlbumApiService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::AlbumApiService)
}
