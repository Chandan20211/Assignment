package com.sample.assignment.presentation.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.assignment.domain.usecase.GetAlbumUseCase

class AlbumViewModelFactory(
    private val getAlbumUseCase: GetAlbumUseCase,
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumViewModel(
            getAlbumUseCase,
        ) as T
    }
}