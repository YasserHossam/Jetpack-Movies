package com.marvel.moviesapp.data.remote.paging

sealed class PaginatedDataType {
    object TopRated : PaginatedDataType()
    object NowPlaying : PaginatedDataType()
    data class Search(val query: String) : PaginatedDataType()
}