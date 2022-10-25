package com.marvel.moviesapp.data.remote.paging

import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.response.BaseListingResponse

class RemoteSearchPagingSource(
    private val dataSource: MoviesRemoteDataSource,
    private val searchQuery: String
) : BaseMoviesPagingSource() {
    override suspend fun getData(currentPage: Int): BaseListingResponse<RemoteMovie> {
        return dataSource.searchMovies(searchQuery, currentPage)
    }
}