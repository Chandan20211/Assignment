package com.sample.assignment.presentation.di.core

import com.sample.assignment.data.api.AlbumAPIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideAlbumAPIService(retrofit: Retrofit): AlbumAPIService {
        return retrofit.create(AlbumAPIService::class.java)
    }

}