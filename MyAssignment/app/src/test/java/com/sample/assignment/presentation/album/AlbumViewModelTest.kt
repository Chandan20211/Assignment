package com.sample.assignment.presentation.album

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.sample.assignment.data.model.Album
import com.sample.assignment.data.repository.album.FakeAlbumRepository
import com.sample.assignment.domain.usecase.GetAlbumUseCase
import com.sample.assignment.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(manifest= Config.NONE,sdk=[Build.VERSION_CODES.M])
@RunWith(AndroidJUnit4::class)
class AlbumViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AlbumViewModel

    @Before
    fun setUp() {
        val fakeAlbumRepository = FakeAlbumRepository()
        val getAlbumUseCase = GetAlbumUseCase(fakeAlbumRepository)
        viewModel = AlbumViewModel(getAlbumUseCase)
    }

    @Test
    fun getAlbums_returnsCurrentList(){
        val albums = mutableListOf<Album>()
        albums.add( Album(1,"1","album_title1"))
        albums.add(Album(2,"1","album_title2"))
        albums.add(Album(2,"1","album_title3"))
        albums.add(Album(2,"1","album_title4"))

        val currentList = viewModel.getAlbums().getOrAwaitValue()
        assertThat(currentList?.isNotEmpty())
        assertThat(currentList).isEqualTo(albums)

    }

}