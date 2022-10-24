package com.marvel.moviesapp.ui.screens.listing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.composable.PaginatedMoviesList
import com.marvel.moviesapp.ui.model.MovieModel

@Composable
fun MovieListingScreen(
    viewModel: MovieListingViewModel = hiltViewModel(),
    input: GetMoviesInput
) {
    val myInput = remember { mutableStateOf(input) }
    myInput.value = input
    val items = remember { derivedStateOf { viewModel.getMovies(input = myInput.value) } }
    val isFavorites = input is GetMoviesInput.Favorites
    MovieListingScreen(
        items.value.collectAsLazyPagingItems(),
        onFavoriteChanged = {
            if (isFavorites)
                viewModel.removeFromFavorites(it)
            else
                viewModel.addToFavorites(it)
        }, isFavorites
    )
}

@Composable
fun MovieListingScreen(
    items: LazyPagingItems<MovieModel>,
    onFavoriteChanged: (MovieModel) -> Unit,
    isFavoritesScreen: Boolean
) {
    PaginatedMoviesList(
        list = items,
        modifier = Modifier.fillMaxSize(),
        favoriteState = onFavoriteChanged,
        isFavoritesScreen
    )
}