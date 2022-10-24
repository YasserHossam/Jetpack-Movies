package com.marvel.moviesapp.di.modules

import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(repository: MoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }
}