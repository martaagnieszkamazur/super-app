package com.martamazurkozlowska.superapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martamazurkozlowska.superapp.app.MainNavigationScreen
import com.martamazurkozlowska.superapp.di.appModule
import com.martamazurkozlowska.superapp.di.dataModule
import com.martamazurkozlowska.superapp.di.dataStoreModule
import com.martamazurkozlowska.superapp.di.networkModule
import com.martamazurkozlowska.superapp.di.storageModule
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    KoinApplication(
        configuration = koinConfiguration {
            modules(appModule, dataModule, networkModule, storageModule, dataStoreModule)
        }
    ) {
        AppTheme {
            MainNavigationScreen()
        }
    }
}