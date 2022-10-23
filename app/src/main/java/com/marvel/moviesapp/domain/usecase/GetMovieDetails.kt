package com.marvel.moviesapp.domain.usecase

import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie

class GetMovieDetails(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(id: Int): Movie {
        return moviesRepository.getMovieDetails(id)
    }
}