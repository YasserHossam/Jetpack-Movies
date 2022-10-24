package com.marvel.moviesapp.domain.usecase

import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie

class AddFavoriteMovieUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movie: Movie) {
        return moviesRepository.addToFavorites(movie)
    }
}