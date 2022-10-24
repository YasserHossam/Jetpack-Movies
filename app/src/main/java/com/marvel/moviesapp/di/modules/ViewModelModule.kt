package com.marvel.moviesapp.di.modules

import com.marvel.moviesapp.di.qualifiers.DomainUiMovieMapper
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.model.mapper.MovieModelMapper
import com.marvel.moviesapp.ui.util.UiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @DomainUiMovieMapper
    @Provides
    fun provideUiMovieMapper(): UiMapper<MovieModel, Movie> {
        return MovieModelMapper()
    }
}