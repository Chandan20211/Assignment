package com.sample.assignment

import android.app.Application
import com.sample.assignment.presentation.di.Injector
import com.sample.assignment.presentation.di.album.AlbumSubComponent
import com.sample.assignment.presentation.di.core.*


class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()

    }

    override fun createAlbumSubComponent(): AlbumSubComponent {

        return appComponent.albumSubComponent().create()
    }


}