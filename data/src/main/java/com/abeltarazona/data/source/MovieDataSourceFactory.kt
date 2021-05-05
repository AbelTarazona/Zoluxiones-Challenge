package com.abeltarazona.data.source

import com.abeltarazona.data.repository.MovieCache
import com.abeltarazona.data.repository.MovieDataSource
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
open class MovieDataSourceFactory @Inject constructor(
    private val movieCache: MovieCache,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) {

    open suspend fun getDataStore(isCached: Boolean): MovieDataSource {
        return if (isCached) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    fun getRemoteDataSource(): MovieDataSource = movieRemoteDataSource
    fun getCacheDataSource(): MovieDataSource = movieCacheDataSource

}