package com.marvel.moviesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.screens.details.MovieDetailsScreen
import com.marvel.moviesapp.ui.screens.listing.MovieListingScreen

@Composable
fun NavigationGraph(navController: NavHostController, textState: MutableState<TextFieldValue>) {
    val onItemClick : (Int) -> Unit = {
        navController.navigate("${NavItem.Details.screen_route}/$it")
    }
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
            composable("${NavItem.DETAILS_ROUTE}/{movieId}",
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })) {
                val movieId = it.arguments?.getInt("movieId") ?: 0
                MovieDetailsScreen()
            }
    }
}