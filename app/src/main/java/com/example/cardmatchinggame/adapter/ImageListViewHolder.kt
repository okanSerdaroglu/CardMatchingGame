package com.example.cardmatchinggame.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.cardmatchinggame.databinding.AdapterImagesBinding
import com.example.cardmatchinggame.viewmodel.ItemImageViewModel

class ImageListViewHolder(var adapterImagesBinding: AdapterImagesBinding) :
    RecyclerView.ViewHolder(adapterImagesBinding.root) {

    fun setViewModel(itemImageViewModel: ItemImageViewModel) {
        adapterImagesBinding.itemImageViewModel = itemImageViewModel
    }

}
