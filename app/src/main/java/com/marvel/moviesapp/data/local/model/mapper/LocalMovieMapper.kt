package com.marvel.moviesapp.data.local.model.mapper

import com.marvel.moviesapp.data.local.model.LocalMovie
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.util.DomainMapper

class LocalMovieMapper : DomainMapper<LocalMovie, Movie> {
    override fun mapToDomainModel(model: LocalMovie): Movie {
        return Movie(
            id = model.id,
            title = model.title,
            poster = model.posterUrl,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )
    }

    override fun mapFromDomainModel(domainModel: Movie): LocalMovie {
        return LocalMovie(
            id = domainModel.id,
            title = domainModel.title,
            posterUrl = domainModel.poster,
            voteAverage = domainModel.voteAverage,
            voteCount = domainModel.voteCount
        )
    }
}