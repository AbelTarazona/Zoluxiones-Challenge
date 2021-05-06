package com.abeltarazona.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abeltarazona.cache.utils.CacheConstants

/**
 * Created by AbelTarazona on 5/05/2021
 */

@Entity(tableName = CacheConstants.CHARACTER_TABLE_NAME)
data class MovieCacheEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @ColumnInfo(name = "header_image")
    val headerImage: String,
    val language: String,
    val title: String,
    val date: String,
    val img: String,
    @ColumnInfo(name = "is_bookmarked")
    val isBookMarked: Boolean
)