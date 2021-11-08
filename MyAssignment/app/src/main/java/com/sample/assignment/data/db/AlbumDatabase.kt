package com.sample.assignment.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.assignment.data.model.Album


@Database(entities = [Album::class],
version = 1,
exportSchema = false
)
abstract class AlbumDatabase : RoomDatabase(){
abstract fun albumDao(): AlbumDao


}