package com.marvel.moviesapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marvel.moviesapp.data.local.model.LocalMovie

@Database(entities = [LocalMovie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DATABASE_NAME = "movies_db"
        const val FAVORITE_MOVIES_TABLE_NAME = "movies_table"
    }
}