package com.tiagomdosantos.rickyandmorty.designsystem.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.tiagomdosantos.rickyandmorty.ui.theme.alertBackground
import com.tiagomdosantos.rickyandmorty.ui.theme.alertOutline
import com.tiagomdosantos.rickyandmorty.ui.theme.alertText
import com.tiagomdosantos.rickyandmorty.ui.theme.errorBackground
import com.tiagomdosantos.rickyandmorty.ui.theme.errorOutline
import com.tiagomdosantos.rickyandmorty.ui.theme.errorText
import com.tiagomdosantos.rickyandmorty.ui.theme.successBackground
import com.tiagomdosantos.rickyandmorty.ui.theme.successOutline
import com.tiagomdosantos.rickyandmorty.ui.theme.successText
import com.tiagomdosantos.rickyandmorty.ui.theme.unknownBackground
import com.tiagomdosantos.rickyandmorty.ui.theme.unknownOutline
import com.tiagomdosantos.rickyandmorty.ui.theme.unknownText

/**
 * Enum class representing different types of badges.
 */
enum class DSBadgeType {
    Success,
    Error,
    Alert,
    Unknown
}

/**
 * A composable function that displays a badge with the specified text and type.
 *
 * @param modifier The modifier to be applied to the badge component. Defaults to [Modifier].
 * @param text The text to be displayed inside the badge.
 * @param type The type of the badge, which determines its appearance.
 */
@Composable
fun DSBadge(
    modifier: Modifier = Modifier,
    text: String,
    type: DSBadgeType
) {
    when (type) {
        DSBadgeType.Success -> SuccessTagComponent(modifier = modifier, text = text)
        DSBadgeType.Error -> ErrorTagComponent(modifier = modifier, text = text)
        DSBadgeType.Unknown -> UnknownTagComponent(modifier = modifier, text = text)
        DSBadgeType.Alert -> AlertTagComponent(modifier = modifier, text = text)
    }
}

/**
 * A composable function that displays a success badge.
 *
 * @param modifier The modifier to be applied to the component.
 * @param text The text to be displayed inside the badge.
 */
@Composable
private fun SuccessTagComponent(
    modifier: Modifier,
    text: String
) {
    BaseTagComponent(
        modifier = modifier,
        text = text,
        backgroundColor = successBackground,
        textColor = successText,
        outlineColor = successOutline
    )
}

/**
 * A composable function that displays an error badge.
 *
 * @param modifier The modifier to be applied to the component.
 * @param text The text to be displayed inside the badge.
 */
@Composable
private fun ErrorTagComponent(
    modifier: Modifier,
    text: String
) {
    BaseTagComponent(
        modifier = modifier,
        text = text,
        backgroundColor = errorBackground,
        textColor = errorText,
        outlineColor = errorOutline
    )
}

/**
 * A composable function that displays an unknown badge.
 *
 * @param modifier The modifier to be applied to the component.
 * @param text The text to be displayed inside the badge.
 */
@Composable
private fun UnknownTagComponent(
    modifier: Modifier,
    text: String
) {
    BaseTagComponent(
        modifier = modifier,
        text = text,
        backgroundColor = unknownBackground,
        textColor = unknownText,
        outlineColor = unknownOutline
    )
}

/**
 * A composable function that displays an alert badge.
 *
 * @param modifier The modifier to be applied to the component.
 * @param text The text to be displayed inside the badge.
 */
@Composable
private fun AlertTagComponent(
    modifier: Modifier,
    text: String
) {
    BaseTagComponent(
        modifier = modifier,
        text = text,
        backgroundColor = alertBackground,
        textColor = alertText,
        outlineColor = alertOutline
    )
}

/**
 * A base composable function that displays a badge with customizable parameters.
 *
 * @param modifier The modifier to be applied to the badge component.
 * @param text The text to be displayed inside the badge.
 * @param cornerRadius The corner radius of the badge. Defaults to 8.dp.
 * @param backgroundColor The background color of the badge. Defaults to [Color.Gray].
 * @param textColor The color of the text inside the badge. Defaults to [Color.White].
 * @param outlineColor The color of the border around the badge. Defaults to [Color.Black].
 * @param borderWidth The width of the border around the badge. Defaults to 1.dp.
 * @param textSize The size of the text inside the badge. Defaults to the bodyMedium font size.
 */
@Composable
private fun BaseTagComponent(
    modifier: Modifier,
    text: String,
    cornerRadius: Dp = 8.dp,
    backgroundColor: Color = Color.Gray,
    textColor: Color = Color.White,
    outlineColor: Color = Color.Black,
    borderWidth: Dp = 1.dp,
    textSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize
) {
    Box(
        modifier = modifier
            .border(
                width = borderWidth,
                color = outlineColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = textSize
        )
    }
}

