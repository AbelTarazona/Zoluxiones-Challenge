package com.abeltarazona.data.models

/**
 * Created by AbelTarazona on 5/05/2021
 */
data class MovieEntity(
    val id: Int,
    val adult: Boolean,
    val headerImage: String,
    val language: String,
    val title: String,
    val date: String,
    val img: String
)