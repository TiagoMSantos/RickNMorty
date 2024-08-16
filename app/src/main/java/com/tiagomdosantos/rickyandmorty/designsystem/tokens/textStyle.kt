package com.tiagomdosantos.rickyandmorty.designsystem.tokens

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tiagomdosantos.rickyandmorty.R

@Composable
fun headlineLarge(): TextStyle {
    return TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.4.sp,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W600,
    )
}
@Composable
fun headline(): TextStyle {
    return TextStyle(
        fontSize = 20.sp,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W600,
    )
}
@Composable
fun titleLarge(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W600,
    )
}
@Composable
fun title(): TextStyle {
    return TextStyle(
        fontSize = 14.sp,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W600,
    )
}
@Composable
fun titleMedium(): TextStyle {
    return TextStyle(
        fontSize = 16.sp,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W400,
    )
}
@Composable
fun body(): TextStyle {
    return TextStyle(
        fontSize = 14.sp,
        lineHeight = 19.6.sp,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W400,
    )
}
@Composable
fun caption(): TextStyle {
    return TextStyle(
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
    )
}

val firaSansFamily = FontFamily(
    Font(R.font.firasans_light, FontWeight.Light),
    Font(R.font.firasans_regular, FontWeight.Normal),
    Font(R.font.firasans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.firasans_medium, FontWeight.Medium),
    Font(R.font.firasans_bold, FontWeight.Bold)
)