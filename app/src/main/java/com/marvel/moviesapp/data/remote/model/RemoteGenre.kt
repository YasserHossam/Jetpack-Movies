package com.marvel.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteGenre(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)