package com.marvel.moviesapp.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.usecase.GetMovieDetailsUseCase
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.util.UiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getDetailsUseCase: GetMovieDetailsUseCase,
    private val movieModelMapper: UiMapper<MovieModel, Movie>
) : ViewModel() {
    private val _state: MutableStateFlow<DetailsViewState> by lazy {
        MutableStateFlow(DetailsViewState.Idle)
    }

    val state: StateFlow<DetailsViewState> = _state

    fun getMovieDetails(movieId: Int) {
        _state.value = DetailsViewState.Loading
        viewModelScope.launch {
            try {
                val movie = getDetailsUseCase(movieId)
                val movieModel = movieModelMapper.mapToUiModel(movie)
                _state.update { DetailsViewState.Data(movieModel) }
            } catch (throwable: Throwable) {
                _state.update { DetailsViewState.Error }
            }
        }
    }
}