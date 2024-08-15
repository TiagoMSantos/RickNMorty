package com.tiagomdosantos.rickyandmorty.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.tiagomdosantos.rickyandmorty.Screen
import com.tiagomdosantos.rickyandmorty.extensions.getCustomNavSuiteType
import com.tiagomdosantos.rickyandmorty.ui.character.CharactersScreen

@Composable
fun MainScreen() {
    var currentDestination by rememberSaveable { mutableStateOf(Screen.CHARACTERS) }
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            Screen.entries.forEach { screen ->
                item(
                    selected = screen == currentDestination,
                    onClick = { currentDestination = screen },
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.title
                        )
                    },
                    label = {
                        Text(text = screen.title)
                    },
                    alwaysShowLabel = true
                )
            }
        },
        layoutType = getCustomNavSuiteType()
    ) {
        when (currentDestination) {
            Screen.EPISODES -> EpisodesScreen()
            else -> CharactersScreen()
        }
    }
}

@Composable
fun EpisodesScreen() {
    Box {
        Text(text = "Episodes")
    }
}