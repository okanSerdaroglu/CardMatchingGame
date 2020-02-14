package com.example.cardmatchinggame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cardmatchinggame.databinding.AdapterImagesBinding
import com.example.cardmatchinggame.model.Box

class ImagesAdapter : RecyclerView.Adapter<ImagesViewHolder>(),IBoxSelected {

    lateinit var binding: AdapterImagesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.adapter_images, parent, false)
        return ImagesViewHolder(binding,this)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBoxSelected(box: Box) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}