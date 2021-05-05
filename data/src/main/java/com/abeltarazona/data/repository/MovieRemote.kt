package com.abeltarazona.data.repository

import com.abeltarazona.data.models.MovieEntity

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface MovieRemote {
    suspend fun getMovies(page: Int): List<MovieEntity>
}