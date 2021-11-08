package com.sample.assignment.presentation.di.core


import com.sample.assignment.data.repository.album.AlbumRepositoryImpl
import com.sample.assignment.data.repository.album.datasource.AlbumLocalDataSource
import com.sample.assignment.data.repository.album.datasource.AlbumRemoteDatasource
import com.sample.assignment.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAlbumRepository(
        albumRemoteDatasource: AlbumRemoteDatasource,
        albumLocalDatasource: AlbumLocalDataSource

    ): AlbumRepository {

        return AlbumRepositoryImpl(
            albumRemoteDatasource,
            albumLocalDatasource
        )


    }



}