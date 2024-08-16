package com.tiagomdosantos.rickyandmorty.designsystem.tokens

import androidx.compose.ui.text.TextStyle

data class Typography(
    val headlineLarge: TextStyle = TextStyle(),
    val headline: TextStyle = TextStyle(),
    val titleLarge: TextStyle = TextStyle(),
    val title: TextStyle = TextStyle(),
    val titleMedium: TextStyle = TextStyle(),
    val body: TextStyle = TextStyle(),
    val caption: TextStyle = TextStyle(),
)

//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
//    /* Other default text styles to override
//    titleLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//    */
//)