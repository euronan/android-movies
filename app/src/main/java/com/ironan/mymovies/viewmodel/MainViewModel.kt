package com.ironan.mymovies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ironan.mymovies.model.Movie
import com.ironan.mymovies.network.ApiFactory
import com.ironan.mymovies.repository.MovieRemoteRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val remoteRepository : MovieRemoteRepository = MovieRemoteRepository(ApiFactory.moviesApi)


    val popularMoviesLiveData = MutableLiveData<MutableList<Movie>>()

    fun fetchMovies(){
        scope.launch {
            val popularMovies = remoteRepository.getPopularMovies()
            popularMoviesLiveData.postValue(popularMovies)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}