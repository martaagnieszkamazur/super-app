package com.martamazurkozlowska.superapp.ui.view.test

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martamazurkozlowska.superapp.ui.theme.AppColors
import com.martamazurkozlowska.superapp.ui.theme.AppTheme
import com.martamazurkozlowska.superapp.ui.theme.AppTypography

@Composable
fun TestView(
    clickCounter: Int,
    message: String,
    onIncrementCounterClick: () -> Unit,
    onMessageButtonClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TestBody(
                text = clickCounter.toString(),
                buttonText = "Increment counter",
                onClick = onIncrementCounterClick,
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            TestBody(
                text = message,
                buttonText = "Clear message",
                onClick = onMessageButtonClick,
            )
        }
    }
}

@Composable
private fun TestBody(
    text: String,
    buttonText: String,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = text,
            style = AppTypography.h1Bold,
            color = AppColors.gray800
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        TestButton(
            text = buttonText,
            onClick = onClick,
        )
    }
}

@Composable
private fun TestButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.blue800
        )
    ) {
        Text(
            text = text,
            style = AppTypography.bodyMediumRegular,
        )
    }
}

@Preview
@Composable
fun TestViewPreview() = AppTheme {
    TestView(
        clickCounter = 0,
        message = "Message",
        onIncrementCounterClick = {},
        onMessageButtonClick = {},
    )
}

