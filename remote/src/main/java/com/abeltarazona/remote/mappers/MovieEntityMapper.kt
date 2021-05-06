package com.abeltarazona.remote.mappers

import com.abeltarazona.data.models.MovieEntity
import com.abeltarazona.remote.models.MovieModel
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */
class MovieEntityMapper @Inject constructor() : EntityMapper<MovieModel, MovieEntity> {
    override fun mapFromModel(model: MovieModel): MovieEntity {
        return MovieEntity(
            id = model.id,
            adult = model.adult,
            headerImage = model.headerImage,
            language = model.language,
            title = model.title,
            date = model.date,
            img = model.img,
            isBookMarked = model.isBookMarked,
            overview = model.overview,
            voteAverage = model.voteAverage
        )
    }
}