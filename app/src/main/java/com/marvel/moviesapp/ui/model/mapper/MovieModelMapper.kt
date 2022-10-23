package com.marvel.moviesapp.ui.model.mapper

import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.util.UiMapper

class MovieModelMapper : UiMapper<MovieModel, Movie> {
    override fun mapToUiModel(model: Movie): MovieModel {
        return MovieModel(
            id = model.id,
            title = model.title,
            poster = model.poster,
            voteAverage = model.voteAverage
        )
    }

    override fun mapFromUiModel(model: MovieModel): Movie {
        return Movie(
            id = model.id,
            title = model.title,
            poster = model.poster,
            voteAverage = model.voteAverage
        )
    }
}