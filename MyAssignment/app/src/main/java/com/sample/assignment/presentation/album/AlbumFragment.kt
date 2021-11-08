package com.sample.assignment.presentation.album

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.assignment.R
import com.sample.assignment.databinding.FragmentAlbumBinding
import com.sample.assignment.presentation.di.Injector

import javax.inject.Inject

class AlbumFragment : Fragment() {
    @Inject
    lateinit var factory: AlbumViewModelFactory
    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var adapter: AlbumAdapter
    private lateinit var binding: FragmentAlbumBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as Injector).createAlbumSubComponent()
            .inject(this)

        albumViewModel= ViewModelProvider(this,factory)
            .get(AlbumViewModel::class.java)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_album, container, false)

        activity?.title =getString(R.string.album_list)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView(){
        binding.albumRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = AlbumAdapter()
        binding.albumRecyclerView.adapter = adapter
        displayAlbumList()
    }

    private fun displayAlbumList(){
        binding.albumProgressBar.visibility = View.VISIBLE
        val responseLiveData = albumViewModel.getAlbums()
        responseLiveData.observe(getViewLifecycleOwner(), Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.albumProgressBar.visibility = View.GONE
            }else{
                binding.albumProgressBar.visibility = View.GONE
                Toast.makeText(activity,getString(R.string.no_data), Toast.LENGTH_LONG).show()
            }
        })
    }


}