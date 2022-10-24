package com.marvel.moviesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.screens.listing.MovieListingScreen
import com.marvel.moviesapp.ui.screens.search.MovieSearchScreen

@Composable
fun NavigationGraph(navController: NavHostController, textState: MutableState<TextFieldValue>) {
    NavHost(navController, startDestination = NavItem.NowPlaying.screen_route) {
        composable(NavItem.NowPlaying.screen_route) {
            MovieListingScreen(input = GetMoviesInput.NowPlaying)
        }
        composable(NavItem.TopRated.screen_route) {
            MovieListingScreen(input = GetMoviesInput.TopRated)
        }
        composable(NavItem.Search.screen_route) {
            MovieSearchScreen(state = textState)
        }
        composable(NavItem.Favorites.screen_route) {

        }
    }
}