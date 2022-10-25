package com.marvel.moviesapp.data.remote.model.mapper

import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.util.DomainMapper

class RemoteMovieMapper : DomainMapper<RemoteMovie, Movie> {
    companion object {
        private const val BASE_IMAGE_PATH = "https://image.tmdb.org/t/p/w300"
    }

    override fun mapToDomainModel(model: RemoteMovie): Movie {
        val image = if (model.posterImagePath != null)
            "${BASE_IMAGE_PATH}${model.posterImagePath}"
        else
            ""
        return Movie(
            id = model.id,
            title = model.title ?: "",
            description = model.description ?: "",
            poster = image,
            voteAverage = model.voteAverage ?: 0f,
            voteCount = model.voteCount ?: 1,
            genres = model.genres?.map { it.name } ?: listOf()
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