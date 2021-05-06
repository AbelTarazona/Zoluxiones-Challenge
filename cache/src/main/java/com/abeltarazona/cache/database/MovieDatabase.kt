package com.abeltarazona.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abeltarazona.cache.dao.MovieDao
import com.abeltarazona.cache.models.MovieCacheEntity
import com.abeltarazona.cache.utils.CacheConstants
import com.abeltarazona.cache.utils.Migrations
import javax.inject.Inject

/**
 * Created by AbelTarazona on 5/05/2021
 */

@Database(
    entities = [MovieCacheEntity::class],
    version = Migrations.DB_VERSION,
    exportSchema = false
)
abstract class MovieDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cachedMovieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            CacheConstants.DB_NAME
        ).build()
    }
}



