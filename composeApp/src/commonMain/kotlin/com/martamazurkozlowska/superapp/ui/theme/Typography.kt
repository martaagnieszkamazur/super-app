package com.martamazurkozlowska.superapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import superapp.composeapp.generated.resources.Res
import superapp.composeapp.generated.resources.hanken_black
import superapp.composeapp.generated.resources.hanken_bold
import superapp.composeapp.generated.resources.hanken_light
import superapp.composeapp.generated.resources.hanken_regular
import superapp.composeapp.generated.resources.lexend_black
import superapp.composeapp.generated.resources.lexend_bold
import superapp.composeapp.generated.resources.lexend_light
import superapp.composeapp.generated.resources.lexend_regular

data class Typography(
    val h1Bold: TextStyle = TextStyle(),
    val h2Bold: TextStyle = TextStyle(),
    val h3Regular: TextStyle = TextStyle(),
    val h3Bold: TextStyle = TextStyle(),
    val bodyMediumBlack: TextStyle = TextStyle(),
    val bodyMediumBold: TextStyle = TextStyle(),
    val bodyMediumRegular: TextStyle = TextStyle(),
    val bodySmallLight: TextStyle = TextStyle(),
    val bodySmallBold: TextStyle = TextStyle(),
    val primaryButton: TextStyle = TextStyle(),
    val navigationItem: TextStyle = TextStyle(),
)

@Composable
fun createTypography(): Typography {
    val lexendFontFamily = getLexendFontFamily()
    val hankenFontFamily = getHankenFontFamily()
    return Typography(
        h1Bold = TextStyle(
            color = AppColors.text,
            fontFamily = hankenFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
            lineHeight = 48.sp,
            letterSpacing = 0.sp,
        ),
        h2Bold = TextStyle(
            color = AppColors.text,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp,
        ),
        h3Regular = TextStyle(
            color = AppColors.text,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp,
        ),
        h3Bold = TextStyle(
            color = AppColors.topAppBarText,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp,
        ),
        bodyMediumBlack = TextStyle(
            color = AppColors.text,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp,
        ),
        bodyMediumBold = TextStyle(
            color = AppColors.text,
            fontFamily = hankenFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp,
        ),
        bodyMediumRegular = TextStyle(
            color = AppColors.text,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp,
        ),
        bodySmallLight = TextStyle(
            color = AppColors.text,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp,
        ),
        bodySmallBold = TextStyle(
            color = AppColors.text,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
        ),
        primaryButton = TextStyle(
            color = AppColors.olive600,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
        ),
        navigationItem = TextStyle(
            color = AppColors.olivePrimary,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp,
        ),
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun getLexendFontFamily() = FontFamily(
    Font(
        resource = Res.font.lexend_black,
        weight = FontWeight.Black,
    ),
    Font(
        resource = Res.font.lexend_bold,
        weight = FontWeight.Bold,
    ),
    Font(
        resource = Res.font.lexend_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.lexend_light,
        weight = FontWeight.Light,
    )
)

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun getHankenFontFamily() = FontFamily(
    Font(
        resource = Res.font.hanken_black,
        weight = FontWeight.Black,
    ),
    Font(
        resource = Res.font.hanken_bold,
        weight = FontWeight.Bold,
    ),
    Font(
        resource = Res.font.hanken_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.hanken_light,
        weight = FontWeight.Light,
    )
)
