package com.abeltarazona.challenge.di

import com.abeltarazona.data.MovieRepositoryImp
import com.abeltarazona.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by AbelTarazona on 5/05/2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideMovieRepository(movieRepository: MovieRepositoryImp): MovieRepository =
        movieRepository
}