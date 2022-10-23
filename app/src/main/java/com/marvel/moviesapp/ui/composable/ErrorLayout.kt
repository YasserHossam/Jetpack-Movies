package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marvel.moviesapp.ui.theme.errorColor

@Composable
fun ErrorLayout(modifier: Modifier = Modifier, errorString: String) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = errorString, modifier = Modifier.align(Alignment.Center),
            color = errorColor
        )
    }
}