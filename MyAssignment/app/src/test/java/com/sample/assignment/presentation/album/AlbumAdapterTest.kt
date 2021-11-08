package com.sample.assignment.presentation.album

import android.content.Context
import android.os.Build
import android.os.Looper.getMainLooper
import com.sample.assignment.data.model.Album
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import android.view.LayoutInflater
import android.view.View
import com.sample.assignment.R
import com.sample.assignment.databinding.AlbumListItemBinding
import org.junit.After
import org.junit.Assert
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.LooperMode
import org.robolectric.annotation.LooperMode.Mode.PAUSED



@Config(manifest= Config.NONE,sdk=[Build.VERSION_CODES.M])
@RunWith(RobolectricTestRunner::class)
@LooperMode(PAUSED)
class AlbumAdapterTest {

     private lateinit var adapter: AlbumAdapter
     private  lateinit var albumList :ArrayList<Album>
     private lateinit var viewHolder: MyViewHolder

    @Throws(Exception::class)
    @Before
    fun setUp()  {
        albumList =ArrayList<Album>()
        albumList.add(Album(1,"1","title1"))
        albumList.add(Album(2,"1","title2"))
        albumList.add(Album(3,"2","title3"))

        adapter = AlbumAdapter()
        adapter.setList(albumList)

    }

    @Test
    fun itemCount() {
        assert(adapter.itemCount == 3)
    }


    @Test
    fun testItemAtPosition() {
        assert(
            adapter.getItemAtPosition(0)?.title
                .equals("title1")
        )

    }

    @Throws(Exception::class)
    @Test
    fun testOnBindViewHolder() {

        val inflater =
            RuntimeEnvironment.application.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val listItemView: View = inflater.inflate(R.layout.album_list_item, null, false);
        viewHolder =MyViewHolder(AlbumListItemBinding.bind(listItemView))
        adapter.onBindViewHolder(viewHolder, 0)

        Assert.assertEquals(viewHolder.bind(albumList[0]),Unit)


    }


    @After
    fun tearDown() {

        shadowOf(getMainLooper()).idle()

    }

}