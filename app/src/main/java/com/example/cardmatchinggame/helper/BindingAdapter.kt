package com.example.cardmatchinggame.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.model.Box
import com.example.cardmatchinggame.viewmodel.ItemImageViewModel

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("setImageBackground")
        fun setImageBackground(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }

        @JvmStatic
        @BindingAdapter("setAdapter")
        fun setAdapter(
            recyclerView: RecyclerView,
            adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        ) {
            recyclerView.adapter = adapter
        }
    }


}