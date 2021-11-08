package com.sample.assignment.data.repository.album.datasourceImpl


import com.sample.assignment.data.api.AlbumAPIService
import com.sample.assignment.data.model.Album
import com.sample.assignment.data.repository.album.datasource.AlbumRemoteDatasource
import retrofit2.Response

class AlbumRemoteDataSourceImpl(
    private val albumService: AlbumAPIService,
): AlbumRemoteDatasource {

    override suspend fun getAlbums(): Response<List<Album>> {
        return albumService.getAlbums()    }

}

