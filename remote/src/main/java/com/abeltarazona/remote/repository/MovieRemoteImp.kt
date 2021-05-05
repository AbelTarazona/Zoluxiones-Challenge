package com.abeltarazona.remote.repository

import com.abeltarazona.data.models.MovieEntity
import com.abeltarazona.data.repository.MovieRemote
import com.abeltarazona.remote.api.MovieService
import com.abeltarazona.remote.mappers.MovieEntityMapper
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieRemoteImp @Inject constructor(
    private val movieService: MovieService,
    private val movieEntityMapper: MovieEntityMapper
) : MovieRemote {
    override suspend fun getMovies(page: Int): List<MovieEntity> {
        return movieService.getMovies(api_key = "19eb744668a458ec1290b5276562cb16", page = page)
            .movies.map { movieModel ->
                movieEntityMapper.mapFromModel(movieModel)
            }
    }
}