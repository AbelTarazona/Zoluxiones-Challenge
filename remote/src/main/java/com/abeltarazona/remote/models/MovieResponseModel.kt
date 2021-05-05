package com.abeltarazona.remote.models

import com.squareup.moshi.Json

/**
 * Created by AbelTarazona on 5/05/2021
 */
data class MovieResponseModel(
    val page: Int,
    @field:Json(name = "results")
    val movies: List<MovieModel>,
    @field:Json(name = "total_pages")
    val totalPages: Int
)