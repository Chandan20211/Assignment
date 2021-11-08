package com.sample.assignment.data.api

import com.sample.assignment.data.model.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumAPIService {

    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>





}