package com.marvel.moviesapp.domain.usecase

import com.marvel.moviesapp.di.qualifiers.IoDispatcher
import com.marvel.moviesapp.domain.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetMovieDetailsUseCase(
    private val moviesRepository: MoviesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(id: Int) = withContext(dispatcher) {
        moviesRepository.getMovieDetails(id)
    }
}