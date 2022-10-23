package com.marvel.moviesapp.ui.screens.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.usecase.GetMoviesUseCase
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.util.UiMapper
import kotlinx.coroutines.flow.map

class GetMoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val mapper: UiMapper<MovieModel, Movie>,
    private val getMoviesInput: GetMoviesInput
) : ViewModel() {
    val items = getMoviesUseCase(getMoviesInput)
        .map { pagingData -> pagingData.map { mapper.mapToUiModel(it) } }
        .cachedIn(viewModelScope)
}