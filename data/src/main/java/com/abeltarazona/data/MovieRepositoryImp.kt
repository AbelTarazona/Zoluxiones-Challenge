package com.abeltarazona.data

import com.abeltarazona.data.mapper.MovieMapper
import com.abeltarazona.data.source.MovieDataSourceFactory
import com.abeltarazona.domain.models.Movie
import com.abeltarazona.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieRepositoryImp @Inject constructor(
    private val dataSourceFactory: MovieDataSourceFactory,
    private val movieMapper: MovieMapper
) : MovieRepository {

    override suspend fun getMovies(page: Int): Flow<List<Movie>> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isCached()
        val movieList = dataSourceFactory.getDataStore(isCached).getMovies(page).map {  movieEntity ->
            movieMapper.mapFromEntity(movieEntity)
        }
        saveMovies(movieList)
        emit(movieList)
    }

    override suspend fun saveMovies(listMovies: List<Movie>) {
        val movieEntities = listMovies.map {  movie ->
            movieMapper.mapToEntity(movie)
        }
        dataSourceFactory.getCacheDataSource().saveMovies(movieEntities)
    }

}