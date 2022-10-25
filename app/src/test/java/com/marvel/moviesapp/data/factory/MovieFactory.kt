package com.marvel.moviesapp.data.factory

import com.marvel.moviesapp.data.local.model.LocalMovie
import com.marvel.moviesapp.data.remote.model.RemoteGenre
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.domain.model.Movie

object MovieFactory {
    private const val id = 1
    private const val title = "Ace Ventura"
    private const val description = "Ace Ventura is a rising movie introducing jim carey..."
    private const val posterUrl = "https://image.com"
    private const val voteAverage = 7.5f
    private const val voteCount = 10
    private val remoteGenres =
        listOf(RemoteGenre(1, "Fantasy"), RemoteGenre(2, "Action"), RemoteGenre(3, "Drama"))
    private val domainGenres = listOf("Fantasy", "Action", "Drama")

    val localMovie = LocalMovie(
        id = id,
        title = title,
        posterUrl = posterUrl,
        voteAverage = voteAverage,
        voteCount = voteCount
    )

    val remoteMovie = RemoteMovie(
        id = id,
        title = title,
        posterImagePath = posterUrl,
        description = description,
        voteAverage = voteAverage,
        voteCount = voteCount,
        genres = remoteGenres
    )

    val domainMovie = Movie(
        id = id,
        title = title,
        description = description,
        poster = posterUrl,
        voteAverage = voteAverage,
        voteCount = voteCount,
        genres = domainGenres
    )

}