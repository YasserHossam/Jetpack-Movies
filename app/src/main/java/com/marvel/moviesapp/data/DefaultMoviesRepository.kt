package com.marvel.moviesapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.marvel.moviesapp.data.local.db.MovieDatabase
import com.marvel.moviesapp.data.local.model.LocalMovie
import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.paging.PaginatedDataType
import com.marvel.moviesapp.data.remote.paging.RemoteMoviePagingSource
import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.util.DomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultMoviesRepository(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val remoteMapper: DomainMapper<RemoteMovie, Movie>,
    private val pageLimit: Int,
    private val moviesDatabase: MovieDatabase,
    private val localMapper: DomainMapper<LocalMovie, Movie>
) : MoviesRepository {
    override fun getNowPlaying(): Flow<PagingData<Movie>> {
        return getPagingMoviesResult(PaginatedDataType.NowPlaying)
    }

    override fun getTopRated(): Flow<PagingData<Movie>> {
        return getPagingMoviesResult(PaginatedDataType.TopRated)
    }

    override fun searchMovies(query: String): Flow<PagingData<Movie>> {
        return getPagingMoviesResult(PaginatedDataType.Search(query))
    }

    override suspend fun addToFavorites(movie: Movie) {
        moviesDatabase.movieDao().insertMovie(localMapper.mapFromDomainModel(movie))
    }

    override fun getFavoriteMovies(): Flow<PagingData<Movie>> {
        return Pager(getPagingConfig(),
            pagingSourceFactory = { moviesDatabase.movieDao().getFavorites() }
        ).flow.map { pager ->
            pager.map { localMapper.mapToDomainModel(it) }
        }
    }

    override suspend fun getMovieDetails(id: Int): Movie {
        return remoteMapper.mapToDomainModel(remoteDataSource.getMovieDetails(id))
    }

    private fun getPagingConfig(): PagingConfig {
        return PagingConfig(pageLimit)
    }

    private fun getPagingMoviesResult(dataType: PaginatedDataType): Flow<PagingData<Movie>> {
        return Pager(
            getPagingConfig(),
            pagingSourceFactory = { RemoteMoviePagingSource(remoteDataSource, dataType) }
        ).flow.map { pager ->
            pager.map { remoteMapper.mapToDomainModel(it) }
        }
    }
}