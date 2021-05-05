package com.abeltarazona.data.repository

import com.abeltarazona.data.models.MovieEntity

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface MovieDataSource {
    // Remote and cache
    suspend fun getMovies(page: Int): List<MovieEntity>

    // Cache
    suspend fun saveMovies(listMovies: List<MovieEntity>)
    suspend fun isCached(): Boolean
}