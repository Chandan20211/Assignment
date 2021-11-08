package com.sample.assignment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.assignment.data.model.Album

@Dao
interface AlbumDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun saveAlbums(albums : List<Album>)

@Query("DELETE FROM album")
suspend fun deleteAllAlbums()

@Query("SELECT * FROM album ORDER BY LOWER(title) ASC")
suspend fun getAlbums():List<Album>
}