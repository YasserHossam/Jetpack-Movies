package com.marvel.moviesapp.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.marvel.moviesapp.R
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.theme.detailsBackgroundColor
import com.marvel.moviesapp.ui.theme.metadataTextColor

@Composable
fun MovieDetailsScreen(movieId: Int) {
//    MovieDetailsScreen(movie)

}

@Composable
fun MovieDetailsScreen(movie: MovieModel) {
    Row(modifier = Modifier.background(detailsBackgroundColor)) {
        Spacer(modifier = Modifier.width(24.dp))
        Column(modifier = Modifier.background(detailsBackgroundColor)) {
            Text(
                text = movie.title,
                color = Color.White,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = movie.voteAverage.toString(),
                    color = metadataTextColor,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = movie.voteAverage.toString(),
                    color = metadataTextColor,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(10.dp))
            Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.poster)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillWidth,
                contentDescription = movie.title,
                error = painterResource(id = R.drawable.movie_placeholder),
                modifier = Modifier.width(160.dp)
            )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Row {
                        repeat(movie.genres.take(2).size) {
                            OutlinedTextField(
                                value = movie.genres[it],
                                onValueChange = {},
                                readOnly = true,
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(50.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color.White,
                                ),
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
                        Text(
                            text = movie.description,
                            color = Color.White,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxSize(),
                            maxLines = 5
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieDetailsPreview() {
    val movie = MovieModel(
        123,
        "Hulk",
        "https://image.tmdb.org/t/p/w300/bVUgMgVozyFScDM3quP412kXrT.jpg",
        "A group of friends enjoying a weekend steal a couple of jetskis racing them out to sea, ending up in a horrific head-on collision. They struggle to find a way home with a badly injured friend while from the waters below predators lurk.",
        9f,
        200,
        listOf("Comedy", "Drama", "Thriller")
    )
    MovieDetailsScreen(movie)
}