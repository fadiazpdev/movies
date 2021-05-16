package com.fadiazp.movies.sources.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<LocalMovie>)

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: Int): LocalMovie
}
