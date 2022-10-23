package com.marvel.moviesapp.domain

import androidx.paging.PagingData
import com.marvel.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getNowPlaying(page: Int): Flow<PagingData<Movie>>

    fun getTopRated(page: Int): Flow<PagingData<Movie>>

    fun searchMovies(query: String, page: Int): Flow<PagingData<Movie>>

    fun getFavorites(query: String, page: Int): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(id: Int): Movie
}