package com.sample.assignment.presentation.album

import android.os.Build
import android.view.LayoutInflater
import androidx.fragment.app.*
import androidx.recyclerview.widget.RecyclerView
import com.sample.assignment.R
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.junit.Assert.*
import org.robolectric.android.controller.ActivityController
import java.lang.Exception


@Config(manifest= Config.NONE,sdk=[Build.VERSION_CODES.M])
@RunWith(RobolectricTestRunner::class)
class AlbumFragmentTest {

    private lateinit var albumFragment: AlbumFragment

    lateinit var activityController: ActivityController<FragmentActivity>

    @Before
    fun setUp(){

        albumFragment =AlbumFragment()
        startFragment(albumFragment)

    }


    private fun startFragment(fragment: Fragment?) {
        activityController = Robolectric.buildActivity(FragmentActivity::class.java)

        activityController.create().start().resume()

        activityController.get()
            .supportFragmentManager
            .beginTransaction()
            .add(albumFragment, null)
            .commit()
    }


    @Test
    @Throws(Exception::class)
    fun shouldNotBeNull() {

        assertNotNull(albumFragment)
    }



}