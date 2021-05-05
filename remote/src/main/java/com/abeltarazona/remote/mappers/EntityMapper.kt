package com.abeltarazona.remote.mappers

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface EntityMapper<M, E> {
    fun mapFromModel(model: M) : E
}