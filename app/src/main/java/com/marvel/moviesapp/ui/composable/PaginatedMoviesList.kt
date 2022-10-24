package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.marvel.moviesapp.ui.model.MovieModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaginatedMoviesList(
    list: LazyPagingItems<MovieModel>,
    modifier: Modifier = Modifier,
    scrollState: LazyListState
) {
    LazyVerticalGrid(state = scrollState, modifier = modifier, cells = GridCells.Fixed(3)) {
        items(list.itemCount) { index ->
            list[index]?.let { MovieItem(movieModel = it) }
        }
    }
}