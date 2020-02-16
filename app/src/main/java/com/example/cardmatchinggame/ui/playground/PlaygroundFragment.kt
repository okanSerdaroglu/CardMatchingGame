package com.example.cardmatchinggame.ui.playground

import android.widget.Toast
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
    var level = 0

    override fun onBind(binding : ViewDataBinding) {
        this.binding = binding as FragmentPlaygroundBinding
        playgroundViewModel = ViewModelProvider(this)[PlaygroundViewModel::class.java]
        PlayGroundFragmentUtils.getPlayGroundViewModel(playgroundViewModel, level)
        binding.lifecycleOwner = this
        binding.playgroundViewModel = playgroundViewModel
        playgroundViewModel.startTimer()
        observeViewModel()
        observePlayFinished()
    }

    private fun observePlayFinished() {
        playgroundViewModel.stepCount.observe(this, Observer {
            if (playgroundViewModel.stepCount.value == 0) {
                Toast.makeText(context, "Bitti", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun observeViewModel() {
        playgroundViewModel.isTimeFinished.observe(this, Observer {
            if(playgroundViewModel.isTimeFinished.value == true) {
                if (playgroundViewModel.isLevelSuccess.value == true) {
                    level ++
                    PlayGroundFragmentUtils.getPlayGroundViewModel(playgroundViewModel, level)
                }
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_playground
    }


}