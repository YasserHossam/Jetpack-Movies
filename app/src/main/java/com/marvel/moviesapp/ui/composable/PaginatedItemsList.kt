package com.marvel.moviesapp.ui.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.marvel.moviesapp.R
import com.marvel.moviesapp.domain.exception.InvalidCredentialsException
import com.marvel.moviesapp.domain.exception.NetworkException
import com.marvel.moviesapp.ui.model.MovieModel

@Composable
fun PaginatedItemsList(
    list: LazyPagingItems<MovieModel>,
    modifier: Modifier = Modifier,
    scrollState: LazyListState
) {
    Column(modifier = modifier) {
        LazyColumn(state = scrollState) {
            items(items = list) { model ->
                model?.let {
                    Spacer(modifier = Modifier.height(20.dp))
                    NormalMovieItem(movieModel = model)
                }
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            list.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            Loader(bottom = false)
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            Loader(bottom = true)
                        }
                    }


                    loadState.refresh is LoadState.Error -> {
                        val error = (loadState.refresh as? LoadState.Error)?.error ?: Throwable()
                        val errorMessage = "Unknown error"
                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            ErrorLayout(errorString = errorMessage)
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        val error = (loadState.append as? LoadState.Error)?.error ?: Throwable()
                        val errorMessage = "Unknown error"
                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            ErrorLayout(errorString = errorMessage)
                        }
                    }
                }
            }
        }
    }
}

@StringRes
private fun provideErrorMessage(throwable: Throwable): Int {
    return when (throwable) {
        InvalidCredentialsException -> R.string.error_credentials
        NetworkException -> R.string.error_network
        else -> R.string.error_unknown
    }
}