package com.sample.assignment.presentation.di

import com.sample.assignment.presentation.di.album.AlbumSubComponent


interface Injector {
   fun createAlbumSubComponent(): AlbumSubComponent

}