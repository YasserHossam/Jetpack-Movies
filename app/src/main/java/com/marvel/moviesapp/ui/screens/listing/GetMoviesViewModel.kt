package com.marvel.moviesapp.ui.screens.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.marvel.moviesapp.di.qualifiers.DomainUiMovieMapper
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.usecase.GetMoviesUseCase
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.util.UiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class GetMoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    @DomainUiMovieMapper private val mapper: UiMapper<MovieModel, Movie>
) : ViewModel() {

    fun getMovies(input: GetMoviesInput) = getMoviesUseCase(input)
        .map { pagingData -> pagingData.map { mapper.mapToUiModel(it) } }
        .cachedIn(viewModelScope)
}