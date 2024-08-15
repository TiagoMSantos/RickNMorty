package com.tiagomdosantos.rickyandmorty

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(val title: String, val icon: ImageVector) {
    CHARACTERS("Characters", Icons.Filled.Face),
    EPISODES("Episodes", Icons.Filled.PlayArrow),
    LOCATION("Location", Icons.Filled.Place),
}
