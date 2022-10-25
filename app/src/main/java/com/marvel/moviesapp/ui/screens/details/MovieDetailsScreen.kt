package com.marvel.moviesapp.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.marvel.moviesapp.R
import com.marvel.moviesapp.ui.composable.ErrorLayout
import com.marvel.moviesapp.ui.composable.Loader
import com.marvel.moviesapp.ui.model.MovieModel
import com.marvel.moviesapp.ui.theme.roundedShape
import com.marvel.moviesapp.ui.theme.textBgColor
import kotlin.math.round

@Composable
fun MovieDetailsScreen(viewModel: DetailsViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    MovieDetailsScreen(state.value)
}

@Composable
fun MovieDetailsScreen(state: DetailsViewState) {
    return when (state) {
        is DetailsViewState.Data -> DataState(movie = state.movieModel)
        DetailsViewState.Error -> ErrorLayout(errorString = stringResource(id = R.string.error_unknown))
        DetailsViewState.Idle -> {}
        DetailsViewState.Loading -> Loader()
    }
}

@Composable
fun DataState(movie: MovieModel) {
    Row (modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 12.dp)){
        Column {
            Text(
                text = movie.title,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Surface(shape = roundedShape) {
                    Text(
                        text = "${movie.voteAverage} / 10",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .background(textBgColor)
                            .padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Surface(shape = roundedShape) {
                    Text(
                        text = "${movie.voteCount} Votes",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .background(textBgColor)
                            .padding(10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                itemsIndexed(movie.genres.take(3)) { index, item ->
                    OutlinedTextField(
                        value = item,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .width(105.dp)
                            .height(50.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                        ),
                        textStyle = TextStyle.Default.copy(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )
                    )
                    if(index < movie.genres.size-1)
                        Spacer(modifier = Modifier.width(14.dp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Surface(shape = roundedShape) {
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
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = movie.description,
                        color = Color.Black,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxSize(),
                        maxLines = 11,
                        letterSpacing = 2.sp,
                        overflow = TextOverflow.Ellipsis
                    )
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
    DataState(movie)
}