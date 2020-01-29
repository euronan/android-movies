package com.ironan.mymovies.repository

import androidx.lifecycle.LiveData
import com.ironan.mymovies.interfaces.MovieDao
import com.ironan.mymovies.model.Movie

class MovieLocalRepository(private val movieDao: MovieDao) {

    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()

    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

}