package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
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
import com.marvel.moviesapp.ui.theme.*
import com.marvel.moviesapp.ui.util.addEmptyLines


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieItem(
    movieModel: MovieModel,
    favoriteState: (MovieModel) -> Unit,
    isFavoritesScreen: Boolean,
    onItemClick: (Int) -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }
    Surface(
        shape = roundedShape, modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 20.dp)
            .width(160.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onItemClick(movieModel.id)},
                onLongClick = {openDialog.value = true },
            )
    ) {
        if (openDialog.value) {
            val (title, confirmText) = when {
                isFavoritesScreen -> Pair("Remove item from favorites?", "Remove")
                else -> Pair("Add item to favorites?", "Add")
            }
            FavoriteDialog(
                onCancel = { openDialog.value = false },
                onConfirm = {
                    openDialog.value = false
                    favoriteState(movieModel)
                },
                text = title,
                confirmButtonText = confirmText
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(bottom = 2.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movieModel.poster)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = movieModel.title,
                    error = painterResource(id = R.drawable.movie_placeholder),
                    modifier = Modifier.fillMaxSize()
                )

                Text(
                    text = movieModel.voteAverage.toString(),
                    modifier = Modifier
                        .width(40.dp)
                        .height(25.dp)
                        .background(color = textBgColor.copy(alpha = 1f), shape = rateTextShape),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = textBgColor.copy(alpha = 0.7f)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = movieModel.title.addEmptyLines(2),
                    textAlign = TextAlign.Start,
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