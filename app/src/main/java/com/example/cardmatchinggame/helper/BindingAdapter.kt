package com.example.cardmatchinggame.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("setImageBackground")
        fun setImageBackground(imageView: ImageView,resource:Int){
            imageView.setBackgroundResource(resource)
        }
        @JvmStatic
        @BindingAdapter("setAdapter")
        fun setAdapter (recyclerView: RecyclerView, adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>){
            recyclerView.adapter = adapter
        }
    }


}