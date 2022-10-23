package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.theme.roundedShape
import com.marvel.moviesapp.ui.theme.textColor


@Composable
fun NormalMovieItem(movieModel: MovieModel) {
    Surface(shape = roundedShape, modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        Box(modifier = Modifier.height(80.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movieModel.poster)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillBounds,
                contentDescription = movieModel.title,
                modifier = Modifier
                    .aspectRatio(1f / 2.5f)
            )
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                color = Color.Black.copy(alpha = 0.6f)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp, top = 4.dp),
                    text = movieModel.title,
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}