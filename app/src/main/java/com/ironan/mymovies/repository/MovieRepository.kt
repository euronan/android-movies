package com.ironan.mymovies.repository

import com.ironan.mymovies.model.Movie
import com.ironan.mymovies.network.MoviesApi

class MovieRepository(private val api : MoviesApi) : BaseRepository() {

    suspend fun getPopularMovies() : MutableList<Movie>?{

        val movieResponse = safeApiCall(
            call = {api.getPopularMovie().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results?.toMutableList()

    }

}