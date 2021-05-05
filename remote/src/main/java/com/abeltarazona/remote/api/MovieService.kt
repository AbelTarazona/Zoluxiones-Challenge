package com.abeltarazona.remote.api

import com.abeltarazona.remote.models.MovieResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface MovieService {

    @GET("/3/movie/upcoming")
    suspend fun getMovies(
        @Query("api_key") api_key: String? = null,
        @Query("page") page: Int? = null
    ) : MovieResponseModel

}