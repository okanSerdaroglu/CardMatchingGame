package com.example.cardmatchinggame

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cardmatchinggame.base.BaseFragment
import com.example.cardmatchinggame.databinding.FragmentPlaygroundBinding
import com.example.cardmatchinggame.viewmodel.PlaygroundViewModel

class PlaygroundFragment : BaseFragment<FragmentPlaygroundBinding>() {

    lateinit var binding: FragmentPlaygroundBinding
    lateinit var playgroundViewModel : PlaygroundViewModel

    override fun onBind(binding : ViewDataBinding) {
        this.binding = binding as FragmentPlaygroundBinding
        playgroundViewModel = ViewModelProvider(this)[PlaygroundViewModel::class.java]
        binding.lifecycleOwner = this
        binding.playgroundViewModel = playgroundViewModel
        playgroundViewModel.startTimer()
        observeViewModel()
    }

    private fun observeViewModel() {
        playgroundViewModel.isTimeFinished.observe(this, Observer {
            if(playgroundViewModel.isTimeFinished.value == true) {
                if (playgroundViewModel.isLevelSuccess.value == true) {
                    //level yükselt
                } else {
                    // level sabit
                }
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_playground
    }
}