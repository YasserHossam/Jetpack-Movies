package com.marvel.moviesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.screens.details.MovieDetailsScreen
import com.marvel.moviesapp.ui.screens.listing.MovieListingScreen

@Composable
fun NavigationGraph(navController: NavHostController, textState: MutableState<TextFieldValue>) {
    val onItemClick = { navController.navigate(NavItem.Details.screen_route) }
    NavHost(navController, startDestination = NavItem.NowPlaying.screen_route) {
            composable(NavItem.NowPlaying.screen_route) {
                MovieListingScreen(input = GetMoviesInput.NowPlaying, onItemClick = onItemClick)
            }
            composable(NavItem.TopRated.screen_route) {
                MovieListingScreen(input = GetMoviesInput.TopRated, onItemClick = onItemClick)
            }
            composable(NavItem.Search.screen_route) {
                MovieListingScreen(input = GetMoviesInput.Search(textState.value.text), onItemClick = onItemClick)
            }
            composable(NavItem.Favorites.screen_route) {
                MovieListingScreen(input = GetMoviesInput.Favorites, onItemClick = onItemClick)
            }
            composable(NavItem.Details.screen_route) {
                MovieDetailsScreen(movieId = 1)
            }
    }
}