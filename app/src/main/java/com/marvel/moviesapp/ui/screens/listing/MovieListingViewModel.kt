package com.marvel.moviesapp.ui.screens.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.marvel.moviesapp.di.qualifiers.DomainUiMovieMapper
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.usecase.AddFavoriteMovieUseCase
import com.marvel.moviesapp.domain.usecase.GetMoviesUseCase
import com.marvel.moviesapp.domain.usecase.RemoveFavoriteMovieUseCase
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.util.UiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListingViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val addToFavoritesUseCase: AddFavoriteMovieUseCase,
    private val removeFavoriteMovieUseCase: RemoveFavoriteMovieUseCase,
    @DomainUiMovieMapper private val mapper: UiMapper<MovieModel, Movie>
) : ViewModel() {

    fun getMovies(input: GetMoviesInput) = getMoviesUseCase(input)
        .map { pagingData -> pagingData.map { mapper.mapToUiModel(it) } }
        .cachedIn(viewModelScope)

    fun addToFavorites(movieModel: MovieModel) {
        viewModelScope.launch {
            addToFavoritesUseCase(mapper.mapFromUiModel(movieModel))
        }
    }

    fun removeFromFavorites(movieModel: MovieModel) {
        viewModelScope.launch {
            removeFavoriteMovieUseCase(movieModel.id)
        }
    }
}