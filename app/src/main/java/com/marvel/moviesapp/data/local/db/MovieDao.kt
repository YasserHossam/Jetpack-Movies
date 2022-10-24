package com.marvel.moviesapp.data.local.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marvel.moviesapp.data.local.model.LocalMovie

@Dao
interface MovieDao {
    @Query("SELECT * FROM ${MovieDatabase.FAVORITE_MOVIES_TABLE_NAME}")
    fun getFavorites(): PagingSource<Int, LocalMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: LocalMovie)

    @Query("DELETE FROM ${MovieDatabase.FAVORITE_MOVIES_TABLE_NAME} WHERE id = :movieId")
    suspend fun deleteMovie(movieId: Int)
}