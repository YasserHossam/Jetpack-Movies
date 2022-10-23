package com.marvel.moviesapp.data.remote.model.mapper

import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.util.DomainMapper

class RemoteMovieMapper : DomainMapper<RemoteMovie, Movie> {
    override fun mapToDomainModel(model: RemoteMovie): Movie {
        return Movie(
            id = model.id,
            title = model.title,
            description = model.description,
            poster = model.posterImagePath,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )
    }

    override fun mapFromDomainModel(domainModel: Movie): RemoteMovie {
        return RemoteMovie(
            id = domainModel.id,
            title = domainModel.title,
            posterImagePath = domainModel.poster,
            voteAverage = domainModel.voteAverage,
            voteCount = domainModel.voteCount,
            description = domainModel.description
        )
    }
}