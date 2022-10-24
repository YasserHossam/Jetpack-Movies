package com.marvel.moviesapp.data.remote

import com.marvel.moviesapp.data.remote.model.RemoteMovie
import com.marvel.moviesapp.data.remote.model.response.BaseListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRemoteDataSource {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int): Response<BaseListingResponse<RemoteMovie>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int): Response<BaseListingResponse<RemoteMovie>>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Response<BaseListingResponse<RemoteMovie>>

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") id: Int): RemoteMovie
}