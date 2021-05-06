package com.abeltarazona.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abeltarazona.cache.models.MovieCacheEntity

/**
 * Created by AbelTarazona on 5/05/2021
 */
@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): List<MovieCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(vararg movie: MovieCacheEntity)

}