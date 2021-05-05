package com.abeltarazona.data.source

import com.abeltarazona.data.models.MovieEntity
import com.abeltarazona.data.repository.MovieDataSource
import com.abeltarazona.data.repository.MovieRemote
import java.lang.UnsupportedOperationException
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieRemoteDataSource @Inject constructor(
    private val movieRemote: MovieRemote
) : MovieDataSource {

    override suspend fun getMovies(page: Int): List<MovieEntity> {
        return movieRemote.getMovies(page)
    }

    override suspend fun saveMovies(listMovies: List<MovieEntity>) {
        throw UnsupportedOperationException("Save movies is not supported for RemoteDataSource")
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource")
    }
}