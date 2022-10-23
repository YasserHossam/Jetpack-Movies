package com.marvel.moviesapp.domain

import androidx.paging.PagingData
import com.marvel.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    companion object {
        const val PAGE_LIMIT = 20
    }

    fun getNowPlaying(): Flow<PagingData<Movie>>

    fun getTopRated(): Flow<PagingData<Movie>>

    fun searchMovies(query: String): Flow<PagingData<Movie>>

    suspend fun addToFavorites(movie: Movie)

    fun getFavoriteMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(id: Int): Movie
}