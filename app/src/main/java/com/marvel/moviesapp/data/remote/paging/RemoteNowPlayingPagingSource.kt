package com.marvel.moviesapp.data.remote.paging

import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.response.BaseListingResponse

class RemoteNowPlayingPagingSource(private val dataSource: MoviesRemoteDataSource) :
    BaseMoviesPagingSource() {
    override suspend fun getData(currentPage: Int): BaseListingResponse<RemoteMovie> {
        return dataSource.getNowPlayingMovies(currentPage)
    }
}