package com.abeltarazona.cache.mapper

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface CacheMapper<T, V> {

    fun mapFromCached(type: T): V

    fun mapToCached(type: V): T

}