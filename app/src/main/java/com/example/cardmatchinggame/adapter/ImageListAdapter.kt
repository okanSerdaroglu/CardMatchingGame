package com.example.cardmatchinggame.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.databinding.AdapterImagesBinding
import com.example.cardmatchinggame.viewmodel.ItemImageViewModel

class ImageListAdapter(var itemImageViewModelList: ArrayList<ItemImageViewModel>) :
    RecyclerView.Adapter<ImageListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val adapterImagesBinding = DataBindingUtil.inflate<AdapterImagesBinding>(
            inflater,
            R.layout.adapter_images,
            parent,
            false
        )
        return ImageListViewHolder(adapterImagesBinding)

    }



    override fun getItemCount(): Int {
        return itemImageViewModelList.size
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        holder.setViewModel(itemImageViewModelList[position])
    }
}