package com.marvel.moviesapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val bottomCornerShape = RoundedCornerShape(
    topStart = 0.dp,
    topEnd = 0.dp,
    bottomStart = 20.dp,
    bottomEnd = 20.dp
)

val roundedShape = RoundedCornerShape(5.dp)

val searchRoundedShape = RoundedCornerShape(20.dp)

val lefCornersRoundedShape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)

val rateTextShape = RoundedCornerShape(3.dp)