package com.example.cardmatchinggame.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.adapter.ImageListAdapter
import com.example.cardmatchinggame.helper.PlayGroundFragmentUtils

class PlaygroundViewModel : ViewModel() {
    lateinit var imageListAdapter : ImageListAdapter

    var totalTime: MutableLiveData<Long> = MutableLiveData(20000)
    var isTimeFinished : MutableLiveData<Boolean> = MutableLiveData(false)
    var isLevelSuccess : MutableLiveData<Boolean> = MutableLiveData(false)
    var countDownInterval:Long = 1000



     fun startTimer () {
        val timer = object: CountDownTimer(totalTime.value!!, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                totalTime.value = millisUntilFinished / 1000
            }
            override fun onFinish() {
                // success kontrolü yapan bir metot ekle
                isLevelSuccess.value = true

                isTimeFinished.value = true
            }
        }
        timer.start()
    }

}