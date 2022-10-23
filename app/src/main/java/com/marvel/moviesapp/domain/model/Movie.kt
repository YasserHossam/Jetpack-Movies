package com.marvel.moviesapp.domain.model

data class Movie(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val poster: String = "",
    val voteAverage: Float = 0f,
    val voteCount: Int = 1,
    val genres: List<String> = listOf()
)