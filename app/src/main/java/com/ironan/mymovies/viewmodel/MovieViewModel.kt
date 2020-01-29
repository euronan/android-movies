package com.ironan.mymovies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ironan.mymovies.MoviesRoomDatabase
import com.ironan.mymovies.model.Movie
import com.ironan.mymovies.repository.MovieLocalRepository
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieLocalRepository: MovieLocalRepository

    val allMovies: LiveData<List<Movie>>

    init {
        val movieDao = MoviesRoomDatabase.getDatabase(application).movieDao()
        movieLocalRepository = MovieLocalRepository(movieDao)
        allMovies = movieLocalRepository.allMovies
    }

    fun insert(movie: Movie) = viewModelScope.launch {
        movieLocalRepository.insert(movie)
    }

}