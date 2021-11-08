package com.sample.assignment.presentation.di.album

import com.sample.assignment.presentation.album.AlbumFragment
import dagger.Subcomponent

@AlbumScope
@Subcomponent(modules = [AlbumModule::class])
interface AlbumSubComponent {
    fun inject(albumFragment: AlbumFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():AlbumSubComponent
    }

}

