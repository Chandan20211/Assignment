package com.sample.assignment.presentation.di.core


import com.sample.assignment.presentation.di.album.AlbumSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class
])
interface AppComponent {

fun albumSubComponent(): AlbumSubComponent.Factory


}