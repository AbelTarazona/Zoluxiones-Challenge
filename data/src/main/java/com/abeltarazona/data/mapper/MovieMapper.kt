package com.abeltarazona.data.mapper

import com.abeltarazona.data.models.MovieEntity
import com.abeltarazona.domain.models.Movie
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieMapper @Inject constructor() : Mapper<MovieEntity, Movie> {
    override fun mapFromEntity(type: MovieEntity): Movie {
        return Movie(
            id = type.id,
            adult = type.adult,
            headerImage = type.headerImage,
            language = type.language,
            title = type.title,
            date = type.date,
            img = type.img,
            isBookMarked = type.isBookMarked,
            overview = type.overview,
            voteAverage = type.voteAverage
        )
    }

    override fun mapToEntity(type: Movie): MovieEntity {
        return MovieEntity(
            id = type.id,
            adult = type.adult,
            headerImage = type.headerImage,
            language = type.language,
            title = type.title,
            date = type.date,
            img = type.img,
            isBookMarked = type.isBookMarked,
            overview = type.overview,
            voteAverage = type.voteAverage
        )
    }
}