package com.ironan.mymovies.network

import com.ironan.mymovies.model.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

import retrofit2.http.GET

interface MoviesApi{

    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<MovieResponse>>

}