package com.tiagomdosantos.rickyandmorty.designsystem.components.buttons

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiagomdosantos.rickyandmorty.designsystem.tokens.firaSansFamily

@Composable
fun DSGradientButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable BoxScope.() -> Unit,
) {
    DesignSystemButton(
        modifier = modifier,
        // Size parameters
        minHeight = 40.dp,
        // Clickable parameters
        enabled = enabled,
        onClick = onClick,
        // Background parameters
        backgroundBrush = Brush.linearGradient(
            colors = listOf(Color(0xFFFD286E), Color(0xFFFF7356)),
        ),
        backgroundShape = CircleShape,
        // Content parameters
        contentTextStyle = TextStyle(
            fontFamily = firaSansFamily,
            fontSize = 14.sp,
            letterSpacing = 0.sp,
        ),
        content = content,
    )
}

@Composable
@Preview
fun DSGradientButtonPreview() {
    DSGradientButton(onClick = {}) {
        Text(text = "BUTTON")
    }
}