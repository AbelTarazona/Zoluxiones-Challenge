package com.abeltarazona.data.repository

import com.abeltarazona.data.models.MovieEntity

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface MovieCache {
    suspend fun getMovies(page: Int): List<MovieEntity>
    suspend fun saveMovies(listMovies: List<MovieEntity>)
    suspend fun isCached(): Boolean
    suspend fun setLastCacheTime(lastCache: Long)
}