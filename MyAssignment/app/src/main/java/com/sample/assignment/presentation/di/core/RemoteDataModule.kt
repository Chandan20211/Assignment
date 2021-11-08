package com.sample.assignment.presentation.di.core


import com.sample.assignment.data.api.AlbumAPIService
import com.sample.assignment.data.repository.album.datasource.AlbumRemoteDatasource
import com.sample.assignment.data.repository.album.datasourceImpl.AlbumRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideAlbumRemoteDataSource(albumService: AlbumAPIService): AlbumRemoteDatasource {
        return AlbumRemoteDataSourceImpl(
            albumService
        )
    }

}