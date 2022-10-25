package com.marvel.moviesapp.ui.screens.listing

import com.marvel.moviesapp.common.MainCoroutineRule
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.usecase.AddFavoriteMovieUseCase
import com.marvel.moviesapp.domain.usecase.GetMoviesUseCase
import com.marvel.moviesapp.domain.usecase.RemoveFavoriteMovieUseCase
import com.marvel.moviesapp.ui.MovieModelProvider
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.util.UiMapper
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MovieListingViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val getMoviesUseCase = mock<GetMoviesUseCase>()
    private val addFavoriteMovieUseCase = mock<AddFavoriteMovieUseCase>()
    private val removeFavoriteMovieUseCase = mock<RemoveFavoriteMovieUseCase>()
    private val dispatcher = StandardTestDispatcher()
    private val mapper = mock<UiMapper<MovieModel, Movie>>()

    private lateinit var viewModel: MovieListingViewModel

    @Before
    fun setup() {
        viewModel = MovieListingViewModel(
            getMoviesUseCase,
            addFavoriteMovieUseCase,
            removeFavoriteMovieUseCase,
            mapper
        )
    }

    @Test
    fun `test add movie to favorites`() = runTest {
        // Given
        val uiModel = MovieModelProvider.uiMovie
        val mappedDomainModel = MovieModelProvider.domainMovie

        // When
        whenever(mapper.mapFromUiModel(uiModel)).thenReturn(mappedDomainModel)
        viewModel.addToFavorites(uiModel)
        delay(200)
        // Then
        verify(addFavoriteMovieUseCase, times(1)).invoke(mappedDomainModel)
    }

    @Test
    fun `test remove movie from favorites`() = runTest {
        // Given
        val uiModel = MovieModelProvider.uiMovie
        val mappedDomainModel = MovieModelProvider.domainMovie

        // When
        whenever(mapper.mapFromUiModel(uiModel)).thenReturn(mappedDomainModel)
        viewModel.removeFromFavorites(uiModel)
        delay(200)

        // Then
        verify(removeFavoriteMovieUseCase, times(1)).invoke(mappedDomainModel.id)
    }
}