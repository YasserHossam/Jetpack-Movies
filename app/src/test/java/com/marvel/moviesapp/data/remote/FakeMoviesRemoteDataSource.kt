package com.marvel.moviesapp.data.remote

import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.response.BaseListingResponse

class FakeMoviesRemoteDataSource : MoviesRemoteDataSource {
    private val moviesResults = mutableListOf<RemoteMovie>()

    fun addMovies(movies: List<RemoteMovie>) {
        moviesResults.addAll(movies)
    }

    override suspend fun getTopRatedMovies(page: Int): BaseListingResponse<RemoteMovie> {
        return BaseListingResponse(page = page, moviesResults)
    }

    override suspend fun getNowPlayingMovies(page: Int): BaseListingResponse<RemoteMovie> {
        return BaseListingResponse(page = page, moviesResults)
    }

    override suspend fun searchMovies(query: String, page: Int): BaseListingResponse<RemoteMovie> {
        return BaseListingResponse(page = page, moviesResults)
    }

    override suspend fun getMovieDetails(id: Int): RemoteMovie {
        return moviesResults[0]
    }
}