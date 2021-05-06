package com.abeltarazona.cache.mapper

import com.abeltarazona.cache.models.MovieCacheEntity
import com.abeltarazona.data.models.MovieEntity
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieCacheMapper @Inject constructor() : CacheMapper<MovieCacheEntity, MovieEntity> {
    override fun mapFromCached(type: MovieCacheEntity): MovieEntity {
        return MovieEntity(
            id = type.id,
            adult = type.adult,
            headerImage = type.headerImage,
            language = type.language,
            title = type.title,
            date = type.date,
            img = type.img,
            isBookMarked = type.isBookMarked
        )
    }

    override fun mapToCached(type: MovieEntity): MovieCacheEntity {
        return MovieCacheEntity(
            id = type.id,
            adult = type.adult,
            headerImage = type.headerImage,
            language = type.language,
            title = type.title,
            date = type.date,
            img = type.img,
            isBookMarked = type.isBookMarked
        )
    }
}