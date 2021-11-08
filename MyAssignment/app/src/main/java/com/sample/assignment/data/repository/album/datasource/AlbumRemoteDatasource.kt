package com.sample.assignment.data.repository.album.datasource

import com.sample.assignment.data.model.Album
import retrofit2.Response

interface AlbumRemoteDatasource {
   suspend fun getAlbums(): Response<List<Album>>
}