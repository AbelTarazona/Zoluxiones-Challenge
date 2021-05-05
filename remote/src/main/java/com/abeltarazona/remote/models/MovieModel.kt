package com.abeltarazona.remote.models

import com.squareup.moshi.Json

/**
 * Created by AbelTarazona on 5/05/2021
 */
data class MovieModel(
    val adult: Boolean,
    @field:Json(name = "backdrop_path")
    val headerImage: String,
    val id: Int,
    @field:Json(name = "original_language")
    val language: String,
    @field:Json(name = "original_title")
    val title: String,
    @field:Json(name = "release_date")
    val date: String,
    @field:Json(name = "poster_path")
    val img: String,
    val isBookMarked: Boolean = false
) {
    //fun getDateYear(): String = date.split("-")[0]
}