package com.marvel.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteMovie(
    @SerializedName("id")
    val id: Int,

    @SerializedName("poster_path")
    val posterImagePath: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val description: String,

    @SerializedName("vote_average")
    val voteAverage: Float,

    @SerializedName("vote_count")
    val voteCount: Int,

    @SerializedName("genres")
    val genres: List<RemoteGenre>? = null
)