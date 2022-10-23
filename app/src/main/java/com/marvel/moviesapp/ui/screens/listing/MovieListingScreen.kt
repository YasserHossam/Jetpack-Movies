package com.marvel.moviesapp.ui.screens.listing

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MovieListingScreen(@StringRes title: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .wrapContentSize(Alignment.TopCenter)
    ) {
//        Text(
//            text = stringResource(title),
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 20.sp
//        )
    }
}