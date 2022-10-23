package com.marvel.moviesapp.domain.usecase

import androidx.paging.PagingData
import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovies(private val moviesRepository: MoviesRepository) {
    operator fun invoke(page: Int): Flow<PagingData<Movie>> {
        return moviesRepository.getFavoriteMovies(page)
    }
}