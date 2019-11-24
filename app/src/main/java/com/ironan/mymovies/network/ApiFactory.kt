package com.ironan.mymovies.network

import com.ironan.mymovies.AppConstants

object ApiFactory {

    val moviesApi : MoviesApi = RetrofitFactory.retrofit(AppConstants.TMDB_BASE_URL).create(MoviesApi::class.java)

}