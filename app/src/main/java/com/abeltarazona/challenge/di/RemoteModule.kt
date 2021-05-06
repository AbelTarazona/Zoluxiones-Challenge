package com.abeltarazona.challenge.di

import com.abeltarazona.challenge.BuildConfig
import com.abeltarazona.data.repository.MovieRemote
import com.abeltarazona.remote.api.MovieService
import com.abeltarazona.remote.api.ServiceFactory
import com.abeltarazona.remote.repository.MovieRemoteImp
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
object RemoteModule {

    @Provides
    @Singleton
    fun provideService(): MovieService {
        return ServiceFactory.create(BuildConfig.DEBUG, BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideMovieRemote(movieRemote: MovieRemoteImp): MovieRemote {
        return movieRemote
    }
}