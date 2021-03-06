package com.example.cardmatchinggame.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cardmatchinggame.databinding.AdapterImagesBinding
import com.example.cardmatchinggame.helper.interfaces.IBoxSelected
import com.example.cardmatchinggame.viewmodel.ItemImageViewModel

class ImageListViewHolder(var adapterImagesBinding: AdapterImagesBinding) :
    RecyclerView.ViewHolder(adapterImagesBinding.root),View.OnClickListener {

    private lateinit var itemImageViewModel : ItemImageViewModel

    fun setViewModel(
        itemImageViewModel: ItemImageViewModel,
        iBoxSelected: IBoxSelected
    ) {
        this.itemImageViewModel = itemImageViewModel
        this.itemImageViewModel.iBoxSelected = iBoxSelected
        adapterImagesBinding.itemImageViewModel = itemImageViewModel
        adapterImagesBinding.root.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        itemImageViewModel.changeState()
    }

}
