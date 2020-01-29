package com.ironan.mymovies.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ironan.mymovies.model.Movie

interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Query("SELECT * FROM movie ORDER BY title ASC")
    fun getAllMovies(): LiveData<List<Movie>>

}