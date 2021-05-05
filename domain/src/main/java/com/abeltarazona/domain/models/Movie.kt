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
)