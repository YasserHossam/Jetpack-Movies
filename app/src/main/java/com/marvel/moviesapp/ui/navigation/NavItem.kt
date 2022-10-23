package com.marvel.moviesapp.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.marvel.moviesapp.R

sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val screen_route: String
) {
    companion object {
        private const val NOW_PLAYING_ROUTE = "now_playing"
        private const val TOP_RATED_ROUTE = "top_rated"
        private const val SEARCH_ROUTE = "search"
        private const val FAVORITES_ROUTE = "favorites"

        fun getObjectFromRoute(route: String): NavItem {
            return when (route) {
                NOW_PLAYING_ROUTE -> NowPlaying
                TOP_RATED_ROUTE -> TopRated
                SEARCH_ROUTE -> Search
                FAVORITES_ROUTE -> Favorites
                else -> NowPlaying
            }
        }
    }

    object NowPlaying :
        NavItem(R.string.bottom_navigation_now_playing, R.drawable.ic_playing, "now_playing")

    object TopRated :
        NavItem(R.string.bottom_navigation_top_rated, R.drawable.ic_medal, "top_rated")

    object Search :
        NavItem(R.string.bottom_navigation_search, R.drawable.ic_search, "search")

    object Favorites :
        NavItem(R.string.bottom_navigation_favorites, R.drawable.ic_favorite, "favorites")
}
