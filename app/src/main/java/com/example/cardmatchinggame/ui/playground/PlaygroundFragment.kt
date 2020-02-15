package com.example.cardmatchinggame.ui.playground

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.base.BaseFragment
import com.example.cardmatchinggame.databinding.FragmentPlaygroundBinding
import com.example.cardmatchinggame.helper.PlayGroundFragmentUtils
import com.example.cardmatchinggame.viewmodel.PlaygroundViewModel

class PlaygroundFragment : BaseFragment<FragmentPlaygroundBinding>() {

    lateinit var binding: FragmentPlaygroundBinding
    lateinit var playgroundViewModel : PlaygroundViewModel

    override fun onBind(binding : ViewDataBinding) {
        this.binding = binding as FragmentPlaygroundBinding
        playgroundViewModel = ViewModelProvider(this)[PlaygroundViewModel::class.java]
        PlayGroundFragmentUtils.getPlayGroundViewModel(playgroundViewModel, 3)
        binding.lifecycleOwner = this
        binding.playgroundViewModel = playgroundViewModel
        //playgroundViewModel.startTimer()
        observeViewModel()
        observeBoxSelected()
    }

    private fun observeBoxSelected() {
        playgroundViewModel.secondSelectedBox.observe(this, Observer {


        })
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