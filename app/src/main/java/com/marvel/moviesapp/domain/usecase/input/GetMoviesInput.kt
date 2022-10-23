package com.marvel.moviesapp.domain.usecase.input

sealed class GetMoviesInput {
    object NowPlaying : GetMoviesInput()
    object TopRated : GetMoviesInput()
    data class Search(val query: String) : GetMoviesInput()
}
