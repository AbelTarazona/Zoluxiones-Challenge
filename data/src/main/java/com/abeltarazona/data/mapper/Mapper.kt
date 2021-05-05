package com.abeltarazona.data.mapper

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface Mapper<E, D> {
    fun mapFromEntity(type: E) : D

    fun mapToEntity(type: D) : E
}