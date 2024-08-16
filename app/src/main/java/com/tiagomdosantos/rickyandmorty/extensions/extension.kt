package com.tiagomdosantos.rickyandmorty.extensions

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.layout.PaneAdaptedValue
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.window.core.layout.WindowWidthSizeClass

@Composable
fun getCustomNavSuiteType(): NavigationSuiteType {
    val adaptiveInfo = currentWindowAdaptiveInfo()
    val customNavSuiteType = with(adaptiveInfo) {
        if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED) {
            NavigationSuiteType.NavigationDrawer
        } else {
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        }
    }
    return customNavSuiteType
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
fun <T> ThreePaneScaffoldNavigator<T>.isListPaneVisible(): Boolean =
    scaffoldValue[ListDetailPaneScaffoldRole.List] == PaneAdaptedValue.Expanded

fun Activity.removeStatusBar() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun fontResources( font: String): Font {
    val context = LocalContext.current
    val fontRes = context.resources.getIdentifier(font, "font", context.packageName)
    return Font(fontRes)
}