package com.example.cardmatchinggame.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<baseViewModel : ViewModel,binding : ViewDataBinding> :
    RecyclerView.Adapter<BaseViewHolder<baseViewModel>>() {

/*
    var mutableList =  MutableLiveData<baseViewModel> ()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<baseViewModel> {
        var holderBinding = DataBindingUtil.inflate<binding>(LayoutInflater.from(parent.context),getLayoutId(),parent,false)
        return BaseViewHolder(holderBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<baseViewModel>, position: Int) {
        holder.onBind(mutableList[position])
    }

     abstract fun getLayoutId () : Int
*/
}