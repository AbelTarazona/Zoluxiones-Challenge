package com.abeltarazona.domain.repository

import com.abeltarazona.domain.models.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface MovieRepository {
    // Remote and cache
    suspend fun getMovies(page: Int): Flow<List<Movie>>

    // Cache
    suspend fun saveMovies(listMovies: List<Movie>)
}