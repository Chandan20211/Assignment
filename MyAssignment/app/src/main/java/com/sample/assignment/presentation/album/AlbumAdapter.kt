package com.sample.assignment.presentation.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.assignment.R
import com.sample.assignment.data.model.Album
import com.sample.assignment.databinding.AlbumListItemBinding


class AlbumAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val albumList = ArrayList<Album>()

    fun setList(albums:List<Album>){
        albumList.clear()
        albumList.addAll(albums)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : AlbumListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.album_list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    fun getItemAtPosition(position: Int): Album? {
        return albumList[position]
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(albumList[position])
    }
}



class MyViewHolder(private val binding: AlbumListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(album:Album){
        binding.titleTextView.text = album.title


   }

}