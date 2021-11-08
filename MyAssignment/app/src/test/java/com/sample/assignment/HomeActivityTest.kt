package com.sample.assignment

import android.os.Build
import org.junit.After
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.junit.Assert.*
import org.robolectric.android.controller.ActivityController
import android.view.View


@Config(manifest= Config.NONE,sdk=[Build.VERSION_CODES.M])
@RunWith(RobolectricTestRunner::class)
class HomeActivityTest{

     private lateinit var homeActivity: HomeActivity

     private lateinit var controller :ActivityController<HomeActivity>

     @Before
     fun setUp(){

          controller = Robolectric.buildActivity(HomeActivity::class.java)
          homeActivity = controller
               .create()
               .start()
               .resume()
               .get()

     }


     @Test
      fun initializeViewsTest() {

          val navHostFragment: View? = homeActivity.findViewById(R.id.nav_host_fragment)
          assertNotNull(navHostFragment)


     }

     @After
     fun tearDown() {

          controller
               .pause()
               .stop()
               .destroy()
     }

}