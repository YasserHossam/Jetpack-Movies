package com.marvel.moviesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marvel.moviesapp.ui.screens.listing.MovieListingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.NowPlaying.screen_route) {
        composable(NavItem.NowPlaying.screen_route) {
            MovieListingScreen(NavItem.NowPlaying.title)
        }
        composable(NavItem.TopRated.screen_route) {
            MovieListingScreen(NavItem.TopRated.title)
        }
        composable(NavItem.Search.screen_route) {
            MovieListingScreen(NavItem.Search.title)
        }
        composable(NavItem.Favorites.screen_route) {
            MovieListingScreen(NavItem.Favorites.title)
        }
    }
}