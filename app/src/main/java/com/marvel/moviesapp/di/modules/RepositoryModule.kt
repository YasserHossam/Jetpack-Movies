package com.marvel.moviesapp.di.modules

import com.marvel.moviesapp.data.DefaultMoviesRepository
import com.marvel.moviesapp.data.local.db.MovieDatabase
import com.marvel.moviesapp.data.local.model.LocalMovie
import com.marvel.moviesapp.data.local.model.mapper.LocalMovieMapper
import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.mapper.RemoteMovieMapper
import com.marvel.moviesapp.data.remote.paging.DefaultMoviesPagingSourceFactory
import com.marvel.moviesapp.data.remote.paging.MoviesPagingSourceFactory
import com.marvel.moviesapp.di.qualifiers.LocalDomainMovieMapper
import com.marvel.moviesapp.di.qualifiers.PageLimit
import com.marvel.moviesapp.di.qualifiers.RemoteDomainMovieMapper
import com.marvel.moviesapp.domain.MoviesRepository
import com.marvel.moviesapp.domain.model.Movie
import com.marvel.moviesapp.domain.util.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMoviesRemoteDataSource(retrofit: Retrofit): MoviesRemoteDataSource {
        return retrofit.create(MoviesRemoteDataSource::class.java)
    }

    @RemoteDomainMovieMapper
    @Provides
    fun provideRemoteMovieMapper(): DomainMapper<RemoteMovie, Movie> {
        return RemoteMovieMapper()
    }

    @LocalDomainMovieMapper
    @Provides
    fun provideLocalMovieMapper(): DomainMapper<LocalMovie, Movie> {
        return LocalMovieMapper()
    }

    @PageLimit
    @Provides
    fun providePageLimit(): Int {
        return 20
    }

    @Provides
    fun provideMoviesPagingSourceFactory(remoteDataSource: MoviesRemoteDataSource): MoviesPagingSourceFactory {
        return DefaultMoviesPagingSourceFactory(remoteDataSource)
    }

    @Provides
    fun provideMoviesRepository(
        remoteDataSource: MoviesRemoteDataSource,
        moviesPagingSourceFactory: MoviesPagingSourceFactory,
        @RemoteDomainMovieMapper remoteMapper: DomainMapper<RemoteMovie, Movie>,
        @PageLimit pageLimit: Int,
        @LocalDomainMovieMapper localMapper: DomainMapper<LocalMovie, Movie>,
        moviesDatabase: MovieDatabase
    ): MoviesRepository {
        return DefaultMoviesRepository(
            remoteDataSource,
            moviesPagingSourceFactory,
            remoteMapper,
            pageLimit,
            moviesDatabase,
            localMapper
        )
    }
}