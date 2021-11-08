package com.sample.assignment.data.repository.album

import com.sample.assignment.data.model.Album
import com.sample.assignment.domain.repository.AlbumRepository

class FakeAlbumRepository :AlbumRepository{

    private val albums = mutableListOf<Album>()


    init {
        albums.add( Album(1,"1","album_title1"))
        albums.add(Album(2,"1","album_title2"))
        albums.add(Album(2,"1","album_title3"))
        albums.add(Album(2,"1","album_title4"))

    }

    override suspend fun getAlbums(): List<Album>? {
        return albums
    }


}