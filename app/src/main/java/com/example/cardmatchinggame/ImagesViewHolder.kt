package com.example.cardmatchinggame

import androidx.recyclerview.widget.RecyclerView
import com.example.cardmatchinggame.databinding.AdapterImagesBinding
import com.example.cardmatchinggame.model.Box

class ImagesViewHolder constructor(binding: AdapterImagesBinding, imagesAdapter: ImagesAdapter) :
    RecyclerView.ViewHolder(binding.root), IBoxSelected {
    override fun onBoxSelected(box: Box) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
