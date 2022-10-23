package com.marvel.moviesapp.ui.composable

import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.marvel.moviesapp.ui.theme.topBarColor

@Composable
fun HomeTopBar(title: CharSequence, modifier: Modifier = Modifier) {
    TopAppBar(title = { HeaderText(title = title.toString()) }, backgroundColor = topBarColor)
}