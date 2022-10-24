package com.marvel.moviesapp.ui.screens.listing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.composable.PaginatedMoviesList

@Composable
fun MovieListingScreen(
    viewModel: GetMoviesViewModel = hiltViewModel(),
    input: GetMoviesInput
) {
    val items = viewModel.getMovies(input = input).collectAsLazyPagingItems()
    val scrollState = rememberLazyListState()
    PaginatedMoviesList(list = items, scrollState = scrollState, modifier = Modifier.fillMaxSize())
}