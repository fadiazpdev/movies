package com.fadiazp.movies.sources.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalMovie::class], version = 1)
abstract class MovieDB : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}