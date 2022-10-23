package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Loader(modifier: Modifier = Modifier, bottom: Boolean = false) {
    val finalModifier = if (bottom)
        modifier.fillMaxWidth()
    else
        modifier.fillMaxSize()
    Box(modifier = finalModifier) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}