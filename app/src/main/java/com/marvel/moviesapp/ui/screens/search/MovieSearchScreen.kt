package com.marvel.moviesapp.ui.screens.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.composable.PaginatedMoviesList
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.screens.listing.GetMoviesViewModel

@Composable
fun MovieSearchScreen(
    viewModel: GetMoviesViewModel = hiltViewModel(),
    state: MutableState<TextFieldValue>
) {
    val items =
        viewModel.getMovies(GetMoviesInput.Search(state.value.text)).collectAsLazyPagingItems()

    PaginatedMoviesList(
        list = items,
        modifier = Modifier.fillMaxSize(),
        favoriteState = { viewModel.addToFavorites(it) }
    )
}