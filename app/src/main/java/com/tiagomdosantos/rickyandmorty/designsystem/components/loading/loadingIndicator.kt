package com.tiagomdosantos.rickyandmorty.designsystem.components.loading

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tiagomdosantos.rickyandmorty.R

@Composable
private fun LoadingDot(
    color: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = CircleShape)
            .background(color = color)
    )
}

//@Composable
//private fun LoadingIndicator(
//    modifier: Modifier = Modifier,
//    color: Color = Colors.,
//    indicatorSpacing: Dp = MarginHalf,
//) {
//    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
//        repeat(NumIndicators) {
//            LoadingDot(
//                modifier = Modifier
//                    .padding(horizontal = indicatorSpacing)
//                    .width(IndicatorWidth.dp)
//                    .aspectRatio(1f),
//                color = color,
//            )
//        }
//    }
//}