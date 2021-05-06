package com.abeltarazona.domain.models

/**
 * Created by AbelTarazona on 5/05/2021
 */
data class Movie(
    val id: Int,
    val adult: Boolean,
    val headerImage: String,
    val language: String,
    val title: String,
    val date: String,
    val img: String,
    val isBookMarked: Boolean
) {
    fun getDateYear(): String = date.split("-")[0]

    fun getImagePoster(): String = "https://image.tmdb.org/t/p/w200$img"
}