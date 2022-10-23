package com.marvel.moviesapp.domain.usecase

import androidx.paging.PagingData
import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class SearchMovies(private val moviesRepository: MoviesRepository) {
    operator fun invoke(query: String): Flow<PagingData<Movie>> {
        return moviesRepository.searchMovies(query)
    }
}