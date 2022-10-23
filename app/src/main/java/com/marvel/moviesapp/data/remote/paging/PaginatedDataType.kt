package com.marvel.moviesapp.data.remote.paging

enum class PaginatedDataType(val query: String? = null) {
    TOP_RATED,
    NOW_PLAYING,
    SEARCH
}