package com.abeltarazona.challenge.di

import android.content.Context
import com.abeltarazona.cache.MovieCacheImp
import com.abeltarazona.cache.dao.MovieDao
import com.abeltarazona.cache.database.MovieDatabase
import com.abeltarazona.data.repository.MovieCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by AbelTarazona on 5/05/2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): MovieDatabase {
        return MovieDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.cachedMovieDao()
    }

    @Provides
    @Singleton
    fun provideMovieCache(movieCache: MovieCacheImp): MovieCache {
        return movieCache
    }
}