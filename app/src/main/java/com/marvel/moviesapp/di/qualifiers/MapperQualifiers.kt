package com.marvel.moviesapp.di.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDomainMovieMapper

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDomainMovieMapper

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DomainUiMovieMapper