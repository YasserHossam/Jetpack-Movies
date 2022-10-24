package com.marvel.moviesapp.domain.usecase

import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie

class RemoveFavoriteMovieUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movieId: Int) {
        return moviesRepository.removeFromFavorites(movieId)
    }
}