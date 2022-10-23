package com.marvel.moviesapp.domain.usecase

import androidx.paging.PagingData
import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val repository: MoviesRepository) {
    operator fun invoke(getMoviesInput: GetMoviesInput): Flow<PagingData<Movie>> {
        return when (getMoviesInput) {
            GetMoviesInput.NowPlaying -> repository.getNowPlaying()
            GetMoviesInput.TopRated -> repository.getTopRated()
            is GetMoviesInput.Search -> repository.searchMovies(getMoviesInput.query)
        }
    }
}