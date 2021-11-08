package com.sample.assignment.domain.repository

import com.sample.assignment.data.model.Album

interface AlbumRepository {
    suspend fun getAlbums():List<Album>?
}