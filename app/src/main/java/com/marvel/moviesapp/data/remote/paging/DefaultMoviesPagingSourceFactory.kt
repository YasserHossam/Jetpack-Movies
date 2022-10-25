package com.marvel.moviesapp.data.remote.paging

import androidx.paging.PagingSource
import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie

class DefaultMoviesPagingSourceFactory(private val remoteDataSource: MoviesRemoteDataSource) :
    MoviesPagingSourceFactory {

    override fun provide(paginatedDataType: PaginatedDataType): PagingSource<Int, RemoteMovie> {
        return when (paginatedDataType) {
            PaginatedDataType.NowPlaying -> RemoteNowPlayingPagingSource(remoteDataSource)
            PaginatedDataType.TopRated -> RemoteTopRatedPagingSource(remoteDataSource)
            is PaginatedDataType.Search ->
                RemoteSearchPagingSource(remoteDataSource, paginatedDataType.query)
        }
    }
}