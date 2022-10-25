package com.marvel.moviesapp.ui

import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.ui.model.MovieModel

object MovieModelProvider {
    private const val id = 1
    private const val title = "Ace Ventura"
    private const val description = "Ace Ventura is a rising movie introducing jim carey..."
    private const val posterUrl = "https://image.com"
    private const val voteAverage = 7.5f
    private const val voteCount = 10
    private val genres = listOf("Fantasy", "Action", "Drama")

    val domainMovie = Movie(
        id = id,
        title = title,
        description = description,
        poster = posterUrl,
        voteAverage = voteAverage,
        voteCount = voteCount,
        genres = genres
    )

    val uiMovie = MovieModel(
        id = id,
        title = title,
        description = description,
        poster = posterUrl,
        voteAverage = voteAverage,
        voteCount = voteCount,
        genres = genres
    )
}