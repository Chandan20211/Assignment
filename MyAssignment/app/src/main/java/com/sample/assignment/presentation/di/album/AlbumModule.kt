package com.sample.assignment.presentation.di.album


import com.sample.assignment.domain.usecase.GetAlbumUseCase
import com.sample.assignment.presentation.album.AlbumViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AlbumModule {
    @AlbumScope
    @Provides
    fun provideAlbumViewModelFactory(
        getAlbumUseCase: GetAlbumUseCase,
    ): AlbumViewModelFactory {
        return AlbumViewModelFactory(
            getAlbumUseCase
        )
    }

}