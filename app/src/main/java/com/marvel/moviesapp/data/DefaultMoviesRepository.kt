package com.marvel.moviesapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.marvel.moviesapp.data.local.db.MovieDatabase
import com.marvel.moviesapp.data.local.model.LocalMovie
import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.paging.MoviesPagingSourceFactory
import com.marvel.moviesapp.data.remote.paging.PaginatedDataType
import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.util.DomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultMoviesRepository(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val moviesPagingSourceFactory: MoviesPagingSourceFactory,
    private val remoteMapper: DomainMapper<RemoteMovie, Movie>,
    private val pageLimit: Int,
    private val moviesDatabase: MovieDatabase,
    private val localMapper: DomainMapper<LocalMovie, Movie>
) : MoviesRepository {
    override fun getNowPlaying(): Flow<PagingData<Movie>> {
        return Pager(
            getPagingConfig(),
            pagingSourceFactory = { moviesPagingSourceFactory.provide(PaginatedDataType.NowPlaying) }
        ).flow.map { pager ->
            pager.map { remoteMapper.mapToDomainModel(it) }
        }
    }

    override fun getTopRated(): Flow<PagingData<Movie>> {
        return Pager(
            getPagingConfig(),
            pagingSourceFactory = { moviesPagingSourceFactory.provide(PaginatedDataType.TopRated) }
        ).flow.map { pager ->
            pager.map { remoteMapper.mapToDomainModel(it) }
        }
    }

    override fun searchMovies(query: String): Flow<PagingData<Movie>> {
        return Pager(
            getPagingConfig(),
            pagingSourceFactory = { moviesPagingSourceFactory.provide(PaginatedDataType.Search(query)) }
        ).flow.map { pager ->
            pager.map { remoteMapper.mapToDomainModel(it) }
        }
    }

    override suspend fun addToFavorites(movie: Movie) {
        moviesDatabase.movieDao().insertMovie(localMapper.mapFromDomainModel(movie))
    }

    override suspend fun removeFromFavorites(movieId: Int) {
        moviesDatabase.movieDao().deleteMovie(movieId)
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
}