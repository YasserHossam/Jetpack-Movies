package com.marvel.moviesapp.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class BaseListingResponse<T>(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<T>
)
