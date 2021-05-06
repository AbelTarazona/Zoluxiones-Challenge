package com.abeltarazona.cache.utils

import androidx.room.migration.Migration

/**
 * Created by AbelTarazona on 5/05/2021
 */
class Migrations {
    companion object {
        const val DB_VERSION = 1

        fun getMigrations(): Array<Migration> {
            return arrayOf()
        }
    }
}