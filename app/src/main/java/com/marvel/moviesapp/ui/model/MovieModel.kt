package com.marvel.moviesapp.ui.model

data class MovieModel(
    val id: Int,
    val title: String,
    val poster: String,
    val voteAverage: Float,
    val isFavored: Boolean = false
)
