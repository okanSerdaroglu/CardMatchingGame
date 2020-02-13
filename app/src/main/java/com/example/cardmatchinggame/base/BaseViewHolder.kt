package com.example.cardmatchinggame.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder <baseViewModel : ViewModel> constructor(private var binding: ViewDataBinding)
    : RecyclerView.ViewHolder(binding.root){

     fun onBind(model: baseViewModel){}

}
