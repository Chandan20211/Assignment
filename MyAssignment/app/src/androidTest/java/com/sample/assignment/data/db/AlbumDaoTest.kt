package com.sample.assignment.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.sample.assignment.data.model.Album
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: AlbumDao
    private lateinit var database: AlbumDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AlbumDatabase::class.java
        ).build()
        dao = database.albumDao()
    }



    @Test
    fun saveAlbumsTest() = runBlocking{
        val albums = listOf(
            Album(1,"1","album_title1"),
            Album(2,"1","album_title2"),
            Album(3,"2","album_title3"),
            Album(4,"2","album_title4"),

            )

        dao.saveAlbums(albums)
        val allAlbums = dao.getAlbums()
        Truth.assertThat(allAlbums).isEqualTo(albums)
    }


    @Test
    fun deleteAlbumsTest() = runBlocking {
        val albums = listOf(
            Album(1,"1","album_title1"),
            Album(2,"1","album_title2"),
            Album(3,"2","album_title3"),
            Album(4,"2","album_title4"),
        )
        dao.saveAlbums(albums)
        dao.deleteAllAlbums()
        val albumResult = dao.getAlbums()
        Truth.assertThat(albumResult).isEmpty()
    }

    @After
    fun tearDown() {
        database.close()
    }
}