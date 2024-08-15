package com.tiagomdosantos.rickyandmorty.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.Coil
import coil.compose.AsyncImage
import coil.transform.CircleCropTransformation
import com.tiagomdosantos.rickyandmorty.domain.models.Character

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    character: Character,
    onClick: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(8.dp)
            .clickable {
                onClick(character.id)
            }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ImageLoader(
                modifier = Modifier.fillMaxWidth(0.7f),
                imageLink = character.imageUrl
            )
            CharacterInfo(
                character = character,
                alignment = Alignment.CenterHorizontally
            )
        }
    }
}

@Composable
fun CharacterListGrid(
    items: LazyPagingItems<Character>,
    listState: LazyGridState = rememberLazyGridState(),
    navigate: (Int) -> Unit = {}
) {

    LazyVerticalGrid(columns = GridCells.Fixed(2), state = listState) {

        items(items.itemCount) { index ->
            items[index]?.let { character ->
                GridItem(character = character, modifier = Modifier.animateContentSize()) {
                    navigate(it)
                }
            }
        }
    }
}

@Composable
fun ImageLoader(
    modifier: Modifier,
    imageLink: String,
    description: String? = null
) {
    AsyncImage(
        model = imageLink,
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun CharacterInfo(
    modifier: Modifier = Modifier,
    character: Character,
    alignment: Alignment.Horizontal = Alignment.Start
) {

}