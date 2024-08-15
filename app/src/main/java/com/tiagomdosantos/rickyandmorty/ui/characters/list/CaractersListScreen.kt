package com.tiagomdosantos.rickyandmorty.ui.characters.list

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.tiagomdosantos.rickyandmorty.designsystem.components.badge.DSBadge
import com.tiagomdosantos.rickyandmorty.designsystem.components.badge.DSBadgeType
import com.tiagomdosantos.rickyandmorty.data.entities.CharacterDto
import com.tiagomdosantos.rickyandmorty.data.entities.Status
import com.tiagomdosantos.rickyandmorty.extensions.isListPaneVisible
import com.tiagomdosantos.rickyandmorty.ui.characters.CharactersListViewModel
import com.tiagomdosantos.rickyandmorty.ui.characters.details.CharacterDetailScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen() {
    val viewModel: CharactersListViewModel = hiltViewModel()
    val characters = viewModel.charactersListState.collectAsLazyPagingItems()
    val navigator = rememberListDetailPaneScaffoldNavigator<CharacterDto>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
    }
    
    ListDetailPaneScaffold(
        modifier = Modifier,
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            AnimatedPane {
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        MediumTopAppBar(
                            title = {
                                Text(
                                    text = "Characters",
                                    fontSize = 32.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            },
                            scrollBehavior = scrollBehavior
                        )
                    },
                    content = { innerPadding ->
                        CharacterList(
                            innerPadding = innerPadding,
                            characters = characters,
                            onItemClick = { character ->
                                navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, character)
                            }
                        )
                    }
                )
            }
        },
        detailPane = {
            AnimatedPane {
                navigator.currentDestination?.content?.let {
                    CharacterDetailScreen(
                        character = it,
                        showBackButton = !navigator.isListPaneVisible(),
                        navigator::navigateBack
                    )
                }
            }
        }
    )
}

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    characters: LazyPagingItems<CharacterDto>,
    onItemClick: (CharacterDto) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = innerPadding
    ) {
        item {
            Spacer(modifier = Modifier.height(36.dp))
        }
        items(characters.itemCount) { index ->
            val character = characters[index]
            character?.let {
                CharacterItem(character, onItemClick)
            }
        }

        // Handle the loading state at the end of the list
        characters.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    // Initial load
                    item { LoadingItem() }
                }
                loadState.append is LoadState.Loading -> {
                    // Load more data
                    item { LoadingItem() }
                }
                loadState.append is LoadState.Error -> {
                    // Load more data failed, display a retry button
                    item {
                        RetryItem { retry() }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(
    character: CharacterDto,
    onItemClick: (CharacterDto) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(128.dp)
            .clickable { onItemClick(character) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop // Adjust content scale as needed
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = character.name,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start),
                )
                Spacer(modifier = Modifier.height(8.dp))
                val tagType = when (character.status) {
                    Status.Alive -> DSBadgeType.Success
                    Status.Dead -> DSBadgeType.Error
                    else -> DSBadgeType.Unknown
                }
                DSBadge(
                    modifier = Modifier.align(Alignment.Start),
                    text = character.status.name,
                    type = tagType
                )
            }
        }
    }
}


@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun RetryItem(onRetry: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = onRetry,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Retry")
        }
    }
}