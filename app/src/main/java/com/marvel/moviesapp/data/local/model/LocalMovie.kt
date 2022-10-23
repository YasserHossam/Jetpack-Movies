package com.marvel.moviesapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marvel.moviesapp.data.local.db.MovieDatabase

@Entity(tableName = MovieDatabase.FAVORITE_MOVIES_TABLE_NAME)
data class LocalMovie(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val title: String = "",
    val posterUrl: String = "",
    val voteAverage: Float = 0f,
    val voteCount: Int = 0
)