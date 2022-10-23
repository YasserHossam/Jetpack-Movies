package com.marvel.moviesapp.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val poster: String,
    val voteAverage: Float,
    val voteCount: Int,
    val genres: List<String> = listOf()
)