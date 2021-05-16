package com.fadiazp.movies.sources.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class LocalMovie (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val voteAverage: String,
    val voteCount: String,
    val releaseDate: String,
    val originalLanguage: String,
    val overview: String
)
