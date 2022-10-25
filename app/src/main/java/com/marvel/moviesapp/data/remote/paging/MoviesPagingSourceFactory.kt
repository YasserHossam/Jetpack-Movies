package com.marvel.moviesapp.data.remote.paging

import androidx.paging.PagingSource
import com.marvel.moviesapp.data.remote.model.RemoteMovie

interface MoviesPagingSourceFactory {
    fun provide(paginatedDataType: PaginatedDataType): PagingSource<Int, RemoteMovie>
}