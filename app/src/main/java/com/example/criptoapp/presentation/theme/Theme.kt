package com.example.criptoapp.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BitcoinOrange,
    onPrimary = DeepNavy,
    primaryContainer = BitcoinDarkOrange,
    onPrimaryContainer = LightTextOnDark,
    secondary = BitcoinLightOrange,
    onSecondary = DeepNavy,
    background = DeepNavy,
    surface = SurfaceDarkBlue,
    onBackground = LightTextOnDark,
    onSurface = LightTextOnDark
)

private val LightColorScheme = lightColorScheme(
    primary = BitcoinOrange,
    onPrimary = Color.White,
    primaryContainer = BitcoinLightOrange,
    onPrimaryContainer = SoftTextDark,
    secondary = SoftBlue,
    onSecondary = SoftTextDark,
    background = WarmWhite,
    surface = LightSurface,
    onBackground = SoftTextDark,
    onSurface = SoftTextDark
)

@Composable
fun CriptoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = poppinsTypo,
        content = content
    )
}