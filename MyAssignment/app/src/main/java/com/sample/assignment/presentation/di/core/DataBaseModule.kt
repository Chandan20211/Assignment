package com.sample.assignment.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.sample.assignment.data.db.AlbumDao
import com.sample.assignment.data.db.AlbumDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideAlbumDataBase(context: Context):AlbumDatabase{
     return Room.databaseBuilder(context,AlbumDatabase::class.java,"album")
         .build()
    }
    @Singleton
    @Provides
    fun provideAlbumDao(albumDatabase: AlbumDatabase):AlbumDao{
        return albumDatabase.albumDao()
    }






}