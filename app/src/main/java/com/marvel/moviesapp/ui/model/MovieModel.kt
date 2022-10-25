package com.marvel.moviesapp.ui.model

data class MovieModel(
    val id: Int,
    val title: String,
    val poster: String,
    val description: String,
    val voteAverage: Float,
    val voteCount: Int,
    val genres: List<String>
)
