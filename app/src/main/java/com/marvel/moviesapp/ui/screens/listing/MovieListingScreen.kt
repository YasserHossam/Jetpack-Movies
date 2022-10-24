package com.marvel.moviesapp.ui.screens.listing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.composable.PaginatedMoviesList
import com.marvel.moviesapp.ui.model.MovieModel

@Composable
fun MovieListingScreen(
    viewModel: GetMoviesViewModel = hiltViewModel(),
    input: GetMoviesInput
) {
    val items = viewModel.getMovies(input = input).collectAsLazyPagingItems()
    MovieListingScreen(items, onFavoriteChanged = { viewModel.addToFavorites(it) })

}

@Composable
fun MovieListingScreen(items: LazyPagingItems<MovieModel>, onFavoriteChanged: (MovieModel) -> Unit) {
    PaginatedMoviesList(
        list = items,
        modifier = Modifier.fillMaxSize(),
        favoriteState = onFavoriteChanged
    )
}