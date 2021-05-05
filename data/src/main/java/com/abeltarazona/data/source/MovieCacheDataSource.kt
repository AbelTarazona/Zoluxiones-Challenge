package com.abeltarazona.data.source

import com.abeltarazona.data.models.MovieEntity
import com.abeltarazona.data.repository.MovieCache
import com.abeltarazona.data.repository.MovieDataSource
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieCacheDataSource @Inject constructor(
    private val movieCache: MovieCache
) : MovieDataSource {
    override suspend fun getMovies(page: Int): List<MovieEntity> {
        return movieCache.getMovies(page)
    }

    override suspend fun saveMovies(listMovies: List<MovieEntity>) {
        movieCache.saveMovies(listMovies)
        movieCache.setLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun isCached(): Boolean {
        return movieCache.isCached()
    }
}