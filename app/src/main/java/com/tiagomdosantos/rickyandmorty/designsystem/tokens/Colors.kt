package com.tiagomdosantos.rickyandmorty.designsystem.tokens

import androidx.compose.ui.graphics.Color

data class Colors(
    val primary: Color,
    val secondary: Color,
    val background: Color,
)

val LightColors = Colors(
    primary = Color(0xFFF53D47),
    secondary = Color(0xFFFFF3F2),
    background = Color(0xFFFAFAFA),
)

val DarkColors = Colors(
    primary = Color(0xFFF53D47),
    secondary = Color(0x1AFFFFFF),
    background = Color(0xFF151515),
)


val darkColor = Color(0xFF272727)
val darkerColor = Color(0xFF1B1B1B)
val darkestColor = Color(0xFF0A0A0A)

val successBackground = Color(red = 233, green = 245, blue = 206)
val successOutline = Color(red = 155, green = 196, blue = 56)
val successText = Color(red = 67, green = 111, blue = 2)

val errorBackground = Color(red = 255, green = 236, blue = 238)
val errorOutline = Color(red = 255, green = 154, blue = 162)
val errorText = Color(red = 187, green = 42, blue = 51)

val unknownBackground = Color(red = 245, green = 246, blue = 247)
val unknownOutline = Color(red = 214, green = 215, blue = 215)
val unknownText = Color(red = 99, green = 99, blue = 99)

val alertBackground = Color(red = 245, green = 205, blue = 112)
val alertOutline = Color(red = 233, green = 188, blue = 94)
val alertText = Color(red = 109, green = 52, blue = 0)