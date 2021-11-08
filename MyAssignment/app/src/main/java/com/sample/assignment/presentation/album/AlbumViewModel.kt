package com.sample.assignment.presentation.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sample.assignment.domain.usecase.GetAlbumUseCase


class AlbumViewModel(
    private val getAlbumUseCase: GetAlbumUseCase,

    ): ViewModel() {

    fun getAlbums() = liveData {
        val albumList = getAlbumUseCase.execute()
        emit(albumList)
    }



}