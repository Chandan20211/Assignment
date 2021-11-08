package com.sample.assignment.domain.usecase

import com.sample.assignment.data.model.Album
import com.sample.assignment.domain.repository.AlbumRepository


class GetAlbumUseCase(private val albumRepository: AlbumRepository) {
    suspend fun execute():List<Album>? = albumRepository.getAlbums()

}