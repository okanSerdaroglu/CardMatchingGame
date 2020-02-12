package com.example.cardmatchinggame.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<fragmentBinding : ViewDataBinding> : Fragment() {

    private lateinit var binding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate<fragmentBinding>(inflater, getLayoutId(), container, false)
        onBind(binding)
        return binding.root
    }

    abstract fun onBind(binding: ViewDataBinding)

    abstract fun getLayoutId(): Int
}