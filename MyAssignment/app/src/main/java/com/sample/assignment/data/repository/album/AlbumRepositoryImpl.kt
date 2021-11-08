package com.sample.assignment.data.repository.album

import android.util.Log
import com.sample.assignment.data.model.Album
import com.sample.assignment.data.repository.album.datasource.AlbumLocalDataSource
import com.sample.assignment.data.repository.album.datasource.AlbumRemoteDatasource
import com.sample.assignment.domain.repository.AlbumRepository

import java.lang.Exception

class AlbumRepositoryImpl(
    private val albumRemoteDatasource: AlbumRemoteDatasource,
    private val albumLocalDataSource: AlbumLocalDataSource,
) : AlbumRepository {
    override suspend fun getAlbums(): List<Album>? {
       return getAlbumsFromDB()
    }



    private suspend fun getAlbumsFromAPI(): List<Album> {
        lateinit var albumList: List<Album>
        try {
            val response = albumRemoteDatasource.getAlbums()
            val body = response.body()
            if(body!=null){
                albumList = body
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return albumList
    }

    private suspend  fun getAlbumsFromDB():List<Album>{
        lateinit var albumList: List<Album>
        try {
            albumList = albumLocalDataSource.getAlbumsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(albumList.isNotEmpty()){
            return albumList
        }else{
            albumList= getAlbumsFromAPI()
            albumLocalDataSource.saveAlbumsToDB(albumList)
            albumList = albumLocalDataSource.getAlbumsFromDB()
        }

        return albumList
    }









}