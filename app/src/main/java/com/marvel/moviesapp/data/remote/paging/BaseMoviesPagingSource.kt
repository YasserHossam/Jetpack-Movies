package com.marvel.moviesapp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.marvel.moviesapp.data.remote.MoviesRemoteDataSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.response.BaseListingResponse
import com.marvel.moviesapp.domain.exception.InvalidCredentialsException
import com.marvel.moviesapp.domain.exception.NetworkException
import com.marvel.moviesapp.domain.exception.UnknownException
import retrofit2.Response
import java.io.IOException

abstract class BaseMoviesPagingSource : PagingSource<Int, RemoteMovie>() {

    override fun getRefreshKey(state: PagingState<Int, RemoteMovie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RemoteMovie> {
        val currentPage = params.key ?: 1
        return try {
            val response = getData(currentPage)
            LoadResult.Page(
                data = response.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = currentPage + 1
            )

        } catch (e: Exception) {
            getException(currentException = e)
        }
    }

    abstract suspend fun getData(currentPage: Int): BaseListingResponse<RemoteMovie>

    private fun getException(
        response: Response<*>? = null,
        currentException: Throwable? = null
    ): LoadResult<Int, RemoteMovie> {
        return when {
            response != null -> {
                if (response.code() == 401)
                    LoadResult.Error(InvalidCredentialsException)
                else
                    LoadResult.Error(UnknownException(response.message()))
            }
            currentException != null -> {
                if (currentException is IOException)
                    LoadResult.Error(NetworkException)
                else
                    LoadResult.Error(UnknownException())
            }

            else -> LoadResult.Error(UnknownException())
        }
    }
}