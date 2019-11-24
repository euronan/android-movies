package com.ironan.mymovies.model

data class Movie (
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val adult: Boolean
)

data class MovieResponse (
    val results: List<Movie>
)