package com.abeltarazona.domain.interactor

import com.abeltarazona.domain.models.Movie
import com.abeltarazona.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */

typealias GetMovieListBaseUseCase = BaseUseCase<Int, Flow<List<Movie>>>

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : GetMovieListBaseUseCase {
    override suspend fun invoke(params: Int): Flow<List<Movie>> =
        movieRepository.getMovies(page = params)
}