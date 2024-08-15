package com.tiagomdosantos.rickyandmorty.ui.characters.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tiagomdosantos.rickyandmorty.designsystem.components.badge.DSBadge
import com.tiagomdosantos.rickyandmorty.designsystem.components.badge.DSBadgeType
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterDto
import com.tiagomdosantos.rickyandmorty.data.entities.Status

@Composable
fun CharacterDetailScreen(
    character: CharacterDto,
    showBackButton: Boolean,
    popBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            CharacterDetailsTopBar(
                title = character.name,
                showBackButton,
                popBack = popBack
            )
        },
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        CharacterDetailsContent(
            character = character,
            innerPadding = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailsTopBar(
    title: String,
    showBackButton: Boolean,
    popBack: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { popBack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Composable
fun CharacterDetailsContent(
    character: CharacterDto,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(innerPadding)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(12.dp))
        CharacterImage(
            imageUrl = character.image,
            name = character.name
        )
        Spacer(modifier = Modifier.size(24.dp))
        CharacterDescription(
            model = CharacterDetailDescriptionModel(status = character.status)
        )
    }
}

@Composable
fun CharacterImage(imageUrl: String?, name: String) {
    imageUrl?.let {
        AsyncImage(
            model = imageUrl,
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(240.dp)
                .clip(CircleShape)
                .background(color = Color.Blue)
        )
    } ?: run {
        Log.e("CharacterImage", "Something went wrong!")
    }
}

@Composable
fun CharacterDescription(model: CharacterDetailDescriptionModel? = null) {
    model?.let {
        val tagType = when (model.status) {
            Status.Alive -> DSBadgeType.Success
            Status.Dead -> DSBadgeType.Error
            else -> DSBadgeType.Unknown
        }
        DSBadge(
            modifier = Modifier,
            text = model.status.name,
            type = tagType
        )
    } ?: run {
        Log.e("CharacterDescription", "Something went wrong!")
    }
}

data class CharacterDetailDescriptionModel(
    val status: Status
)

