package com.marvel.moviesapp.data.remote.paging

import androidx.paging.PagingSource
import com.marvel.moviesapp.data.factory.MovieProvider
import com.marvel.moviesapp.data.remote.FakeExceptionMoviesDataSource
import com.marvel.moviesapp.data.remote.FakeMoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.domain.exception.NetworkException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class RemoteNowPlayingMoviesPagingSourceTest {
    private val fakeMovies = listOf(
        MovieProvider.remoteMovie,
        MovieProvider.remoteMovie.copy(id = 3, title = "Hunger Games", voteAverage = 8f),
        MovieProvider.remoteMovie.copy(id = 5, title = "The Lion King", voteAverage = 10f)
    )

    private val fakeDataSource = FakeMoviesRemoteDataSource().apply {
        addMovies(fakeMovies)
    }

    private val fakeExceptionDataSource = FakeExceptionMoviesDataSource()

    @Test
    fun `Test getting page of now playing movies successfully when fetching first page`() =
        runTest {
            // Given
            val pagingSource = RemoteNowPlayingPagingSource(fakeDataSource)
            val expectedResult =
                PagingSource.LoadResult.Page(data = fakeMovies, prevKey = null, nextKey = 2)
            // When
            val actualResult = pagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = true
                )
            )

            // Then
            assertEquals(
                expected = expectedResult,
                actual = actualResult
            )
        }

    @Test
    fun `Test getting internet exception if io exception was thrown`() =
        runTest {
            // Given
            val pagingSource = RemoteNowPlayingPagingSource(fakeExceptionDataSource)
            val expectedResult =
                PagingSource.LoadResult.Error<Int, RemoteMovie>(NetworkException)

            // When
            val actualResult = pagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = true
                )
            )

            // Then
            assertEquals(
                expected = expectedResult,
                actual = actualResult
            )
        }


}