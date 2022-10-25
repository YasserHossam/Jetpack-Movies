package com.marvel.moviesapp.domain.usecase

import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.usecase.input.GetMoviesInput
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test

class GetMoviesUseCaseTest {
    private val moviesRepository = mock<MoviesRepository>()

    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun setup() {
        getMoviesUseCase = GetMoviesUseCase(moviesRepository)
    }

    @Test
    fun `Test calling repository's GetNowPlaying when the input is NowPlaying`() {
        // Given
        val input = GetMoviesInput.NowPlaying

        // When
        getMoviesUseCase.invoke(input)

        // Then
        verify(moviesRepository, times(1)).getNowPlaying()
    }

    @Test
    fun `Test calling repository's GetTopRatedMovies when the input is TopRated`() {
        // Given
        val input = GetMoviesInput.TopRated

        // When
        getMoviesUseCase.invoke(input)

        // Then
        verify(moviesRepository, times(1)).getTopRated()
    }

    @Test
    fun `Test calling repository's GetFavoriteMovies when the input is Favorites`() {
        // Given
        val input = GetMoviesInput.Favorites

        // When
        getMoviesUseCase.invoke(input)

        // Then
        verify(moviesRepository, times(1)).getFavoriteMovies()
    }

    @Test
    fun `Test calling repository's Search Movies when the input is Search`() {
        // Given
        val query = "man"
        val input = GetMoviesInput.Search(query)

        // When
        getMoviesUseCase.invoke(input)

        // Then
        verify(moviesRepository, times(1)).searchMovies(query)
    }
}