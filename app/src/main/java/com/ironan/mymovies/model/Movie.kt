package com.ironan.mymovies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie (
    @PrimaryKey val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val adult: Boolean
)

data class MovieResponse (
    val results: List<Movie>
)