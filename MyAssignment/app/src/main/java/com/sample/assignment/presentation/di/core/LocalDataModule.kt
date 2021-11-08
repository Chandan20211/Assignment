package com.sample.assignment.presentation.di.core

import com.sample.assignment.data.db.AlbumDao
import com.sample.assignment.data.repository.album.datasource.AlbumLocalDataSource
import com.sample.assignment.data.repository.album.datasourceImpl.AlbumLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideAlbumLocalDataSource(albumDao: AlbumDao): AlbumLocalDataSource {
        return AlbumLocalDataSourceImpl(albumDao)
    }




}