package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.marvel.moviesapp.R
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.theme.roundedShape
import com.marvel.moviesapp.ui.theme.textBgColor
import com.marvel.moviesapp.ui.theme.textColor
import com.marvel.moviesapp.ui.util.addEmptyLines


@Composable
fun MovieItem(movieModel: MovieModel) {
    Surface(
        shape = roundedShape, modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .width(100.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movieModel.poster)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Fit,
                contentDescription = movieModel.title,
                error = painterResource(id = R.drawable.movie_placeholder),
                modifier = Modifier.fillMaxSize()
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = textBgColor.copy(alpha = 0.7f)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = movieModel.title.addEmptyLines(2),
                    textAlign = TextAlign.Center,
                    color = textColor,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}