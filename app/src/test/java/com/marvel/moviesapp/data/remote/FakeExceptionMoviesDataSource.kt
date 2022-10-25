package com.marvel.moviesapp.data.remote

import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.response.BaseListingResponse
import java.io.IOException

class FakeExceptionMoviesDataSource : MoviesRemoteDataSource {

    override suspend fun getTopRatedMovies(page: Int): BaseListingResponse<RemoteMovie> {
        throw IOException()
    }

    override suspend fun getNowPlayingMovies(page: Int): BaseListingResponse<RemoteMovie> {
        throw IOException()
    }

    override suspend fun searchMovies(query: String, page: Int): BaseListingResponse<RemoteMovie> {
        throw IOException()
    }

    override suspend fun getMovieDetails(id: Int): RemoteMovie {
        throw IOException()
    }
}