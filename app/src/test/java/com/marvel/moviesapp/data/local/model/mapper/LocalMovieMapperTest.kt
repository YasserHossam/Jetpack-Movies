package com.marvel.moviesapp.data.local.model.mapper

import com.marvel.moviesapp.data.factory.MovieFactory
import org.junit.Assert
import org.junit.Test


class LocalMovieMapperTest {
    private val mapper = LocalMovieMapper()

    @Test
    fun `test mapping from local model to domain model returns correct results`() {
        // Given
        val localMovie = MovieFactory.localMovie
        val correctMappedMovie = MovieFactory.domainMovie

        // When
        val mapTestResult = mapper.mapToDomainModel(localMovie)


        Assert.assertEquals(mapTestResult.id, correctMappedMovie.id)
        Assert.assertEquals(mapTestResult.poster, correctMappedMovie.poster)
        Assert.assertEquals(mapTestResult.title, correctMappedMovie.title)
        Assert.assertEquals(mapTestResult.voteAverage, correctMappedMovie.voteAverage)
        Assert.assertEquals(mapTestResult.voteCount, correctMappedMovie.voteCount)
    }

    @Test
    fun `test mapping from domain model to local model returns correct results`() {
        // Given
        val domainMovie = MovieFactory.domainMovie
        val correctMappedMovie = MovieFactory.localMovie

        // When
        val mapTestResult = mapper.mapFromDomainModel(domainMovie)


        Assert.assertEquals(mapTestResult.id, correctMappedMovie.id)
        Assert.assertEquals(mapTestResult.posterUrl, correctMappedMovie.posterUrl)
        Assert.assertEquals(mapTestResult.title, correctMappedMovie.title)
        Assert.assertEquals(mapTestResult.voteAverage, correctMappedMovie.voteAverage)
        Assert.assertEquals(mapTestResult.voteCount, correctMappedMovie.voteCount)
    }
}