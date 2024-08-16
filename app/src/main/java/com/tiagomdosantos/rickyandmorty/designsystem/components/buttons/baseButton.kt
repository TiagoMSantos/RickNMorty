package com.tiagomdosantos.rickyandmorty.designsystem.components.buttons

import androidx.annotation.FloatRange
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DesignSystemMaterial3Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable BoxScope.() -> Unit,
) {
    DesignSystemButton(
        modifier = modifier,
        // Size parameters
        minWidth = ButtonDefaults.MinWidth,
        minHeight = ButtonDefaults.MinHeight,
        // Clickable parameters
        indication = rememberRipple(),
        enabled = enabled,
        onClick = onClick,
        // Background parameters
        backgroundColor = MaterialTheme.colorScheme.primary,
        backgroundShape = ButtonDefaults.shape,
        // Content parameters
        contentColor = MaterialTheme.colorScheme.onPrimary,
        contentTextStyle = MaterialTheme.typography.labelLarge,
        contentPaddingValues = ButtonDefaults.ContentPadding,
        content = content,
    )
}

@Composable
fun DesignSystemButton(
    modifier: Modifier = Modifier,
    // Size parameters
    minWidth: Dp = 80.dp,
    minHeight: Dp = 48.dp,
    // Clickable parameters
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    onClick: () -> Unit,
    // Background parameters
    backgroundColor: Color = Color.DarkGray,
    backgroundShape: Shape = RoundedCornerShape(size = 16.dp),
    backgroundPaddingValues: PaddingValues = PaddingValues(all = 0.dp),
    // Content parameters
    contentColor: Color = Color.White,
    contentTextStyle: TextStyle = TextStyle.Default,
    contentAlignment: Alignment = Alignment.Center,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
    content: @Composable BoxScope.() -> Unit,
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        LocalTextStyle provides contentTextStyle,
    ) {
        Box(
            modifier = modifier
                .defaultMinSize(
                    minWidth = minWidth,
                    minHeight = minHeight,
                )
                .padding(paddingValues = backgroundPaddingValues)
                .background(
                    color = backgroundColor,
                    shape = backgroundShape,
                )
                .clip(shape = backgroundShape)
                .clickable(
                    interactionSource = interactionSource,
                    indication = indication,
                    enabled = enabled,
                    onClickLabel = onClickLabel,
                    role = Role.Button,
                    onClick = onClick
                )
                .padding(paddingValues = contentPaddingValues),
            contentAlignment = contentAlignment,
            content = content,
        )
    }
}

@Composable
fun DesignSystemButton(
    modifier: Modifier = Modifier,
    // Size parameters
    minWidth: Dp = 80.dp,
    minHeight: Dp = 48.dp,
    // Clickable parameters
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    onClick: () -> Unit,
    // Background parameters
    backgroundBrush: Brush = Brush.linearGradient(
        colors = listOf(Color.DarkGray, Color.Green)
    ),
    backgroundShape: Shape = RoundedCornerShape(size = 16.dp),
    @FloatRange(from = 0.0, to = 1.0)
    backgroundAlpha: Float = 1.0f,
    backgroundPaddingValues: PaddingValues = PaddingValues(all = 0.dp),
    // Content parameters
    contentColor: Color = Color.White,
    contentTextStyle: TextStyle = TextStyle.Default,
    contentAlignment: Alignment = Alignment.Center,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
    content: @Composable BoxScope.() -> Unit,
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        LocalTextStyle provides contentTextStyle,
    ) {
        Box(
            modifier = modifier
                .defaultMinSize(
                    minWidth = minWidth,
                    minHeight = minHeight,
                )
                .padding(paddingValues = backgroundPaddingValues)
                .background(
                    brush = backgroundBrush,
                    shape = backgroundShape,
                    alpha = backgroundAlpha,
                )
                .clip(shape = backgroundShape)
                .clickable(
                    interactionSource = interactionSource,
                    indication = indication,
                    enabled = enabled,
                    onClickLabel = onClickLabel,
                    role = Role.Button,
                    onClick = onClick
                )
                .padding(paddingValues = contentPaddingValues),
            contentAlignment = contentAlignment,
            content = content,
        )
    }
}

@Composable
@Preview
fun DesignSystemButtonPreview() {
    DesignSystemButton(onClick = {}) {
        Text(text = "Button")
    }
}

@Composable
@Preview
fun DesignSystemMaterial3ButtonPreview() {
    MaterialTheme {
        DesignSystemMaterial3Button(onClick = {}) {
            Text(text = "Button")
        }
    }
}