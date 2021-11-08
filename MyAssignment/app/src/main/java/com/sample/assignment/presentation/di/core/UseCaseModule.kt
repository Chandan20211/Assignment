package com.sample.assignment.presentation.di.core


import com.sample.assignment.domain.repository.AlbumRepository
import com.sample.assignment.domain.usecase.GetAlbumUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAlbumUseCase(albumRepository: AlbumRepository):GetAlbumUseCase{
        return GetAlbumUseCase(albumRepository)
    }




}