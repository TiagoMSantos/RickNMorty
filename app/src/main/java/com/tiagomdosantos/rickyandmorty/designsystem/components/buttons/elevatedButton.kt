package com.tiagomdosantos.rickyandmorty.designsystem.components.buttons

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiagomdosantos.rickyandmorty.designsystem.tokens.firaSansFamily

@Composable
fun DSElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable BoxScope.() -> Unit,
) {
    val cornerRadius = 12.dp
    val shadowHeight = 5.dp
    DesignSystemButton(
        // Custom "drop shadow" via modifier
        modifier = modifier.drawBehind {
            drawRoundRect(
                color = Color(0xFF6CA530),
                cornerRadius = CornerRadius(cornerRadius.toPx()),
            )
        },
        // Size parameters
        minHeight = 48.dp + shadowHeight,
        // Clickable parameters
        enabled = enabled,
        onClick = onClick,
        // Background parameters
        backgroundColor = Color(0xFF58CC02),
        backgroundShape = RoundedCornerShape(size = cornerRadius),
        backgroundPaddingValues = PaddingValues(bottom = shadowHeight),
        // Content parameters
        contentTextStyle = TextStyle(
            fontFamily = firaSansFamily,
            fontSize = 16.sp,
            letterSpacing = 1.5.sp,
        ),
        content = content,
    )
}

@Composable
@Preview
fun DSElevatedButtonPreview() {
    DSElevatedButton(onClick = {}) {
        Text(text = "BUTTON")
    }
}