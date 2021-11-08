package com.sample.assignment.data.repository.album.datasource

import com.sample.assignment.data.model.Album

interface AlbumLocalDataSource {
  suspend fun getAlbumsFromDB():List<Album>
  suspend fun saveAlbumsToDB(albums:List<Album>)
  suspend fun clearAll()
}