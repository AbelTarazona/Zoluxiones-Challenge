package com.abeltarazona.domain.models

import java.io.Serializable

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
    val isBookMarked: Boolean,
    val overview: String,
    val voteAverage: Double,

    ) : Serializable {
    fun getDateYear(): String = date.split("-")[0]

    fun getLanguageType(): String {
        when(language) {
            "es" -> return "Español"
            "en" -> return "Inglés"
            "ja" -> return "Japonés"
        }
        return "XX"
    }

    fun getImagePoster(): String = "https://image.tmdb.org/t/p/w200$img"
}