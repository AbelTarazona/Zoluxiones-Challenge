package com.abeltarazona.cache

import com.abeltarazona.cache.dao.MovieDao
import com.abeltarazona.cache.mapper.MovieCacheMapper
import com.abeltarazona.data.models.MovieEntity
import com.abeltarazona.data.repository.MovieCache
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieCacheImp @Inject constructor(
    private val movieDao: MovieDao,
    private val movieCacheMapper: MovieCacheMapper,
) : MovieCache {

    override suspend fun getMovies(page: Int): List<MovieEntity> {
        return movieDao.getMovies().map {  movieCacheEntity ->
            movieCacheMapper.mapFromCached(movieCacheEntity)
        }
    }

    override suspend fun saveMovies(listMovies: List<MovieEntity>) {
        movieDao.addMovie(
            *listMovies.map {  movieCacheEntity ->
                movieCacheMapper.mapToCached(movieCacheEntity)
            }.toTypedArray()
        )
    }

    override suspend fun isCached(): Boolean {
        return movieDao.getMovies().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        // Pending to add (Function: Set timer for delete the data)
    }


}