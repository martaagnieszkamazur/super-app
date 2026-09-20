package com.martamazurkozlowska.superapp.app.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martamazurkozlowska.superapp.ui.view.test.TestView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TestScreen(
    viewModel: TestViewModel = koinViewModel(),
) {
    val clickCounter by viewModel.clickCounterFlow.collectAsStateWithLifecycle()
    val message by viewModel.messageFlow.collectAsStateWithLifecycle()

    TestView(
        clickCounter = clickCounter,
        message = message,
        onIncrementCounterClick = viewModel::onIncrementCounterClick,
        onMessageButtonClick = viewModel::onMessageButtonClick,
    )
}