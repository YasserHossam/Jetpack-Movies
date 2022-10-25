package com.marvel.moviesapp.ui.screens.details

import com.marvel.moviesapp.ui.model.MovieModel

sealed class DetailsViewState {
    object Idle : DetailsViewState()
    object Loading : DetailsViewState()
    data class Data(val movieModel: MovieModel) : DetailsViewState()
    object Error : DetailsViewState()
}
