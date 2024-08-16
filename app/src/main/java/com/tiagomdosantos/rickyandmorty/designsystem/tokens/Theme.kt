package com.tiagomdosantos.rickyandmorty.designsystem.tokens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val localDimens = staticCompositionLocalOf { Dimensions() }
private val localColorScheme = staticCompositionLocalOf { LightColors }
private val localRadius = staticCompositionLocalOf { Radius() }
private val localTypography = staticCompositionLocalOf { Typography() }

object Theme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = localColorScheme.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = localTypography.current

    val radius: Radius
        @Composable
        @ReadOnlyComposable
        get() = localRadius.current

    val dimens: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = localDimens.current
}

@Composable
fun DSTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (useDarkTheme) DarkColors else LightColors

    val typography = Typography(
        headlineLarge = headlineLarge(),
        headline = headline(),
        titleLarge = titleLarge(),
        title = title(),
        titleMedium = titleMedium(),
        body = body(),
        caption = caption(),
    )

    CompositionLocalProvider(
        localColorScheme provides colorScheme,
        localTypography provides typography,
        localDimens provides Dimensions(),
        localRadius provides Radius(),
    ) {
        content()
    }
}