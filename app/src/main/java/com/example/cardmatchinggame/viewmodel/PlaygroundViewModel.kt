package com.example.cardmatchinggame.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.model.Box
import com.example.cardmatchinggame.model.Level

class PlaygroundViewModel : ViewModel() {

    init { prepareLevelList() }

    var totalTime: MutableLiveData<Long> = MutableLiveData(20000)
    var isTimeFinished : MutableLiveData<Boolean> = MutableLiveData(false)
    var isLevelSuccess : MutableLiveData<Boolean> = MutableLiveData(false)

    var countDownInterval:Long = 1000

    private fun getBoxNumberOfLevel (levelID : Int) : Int {

        return when (levelID) {
            1 -> {
                 LevelNumbers.LEVEL_1.value
            }
            2 -> {
                 LevelNumbers.LEVEL_2.value
            }
            3 -> {
                 LevelNumbers.LEVEL_3.value
            }
            4 -> {
                 LevelNumbers.LEVEL_4.value
            }
            else -> return LevelNumbers.LEVEL_DEF.value
        }

    }

    private fun prepareLevelList () : ArrayList<Level>{

        val levelList = ArrayList<Level>()
        for (j in 1..4){
            val boxList = ArrayList<Box>()
            for (i in 0 until getBoxNumberOfLevel(j)) {
                 val box = Box(i)
                 // random resim alan metod
                 boxList.add(box)
            }
            boxList.addAll(boxList)
            val level = Level(j, boxList.shuffled() as ArrayList<Box>)
            levelList.add(level)
        }

        return levelList
    }

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

    enum class LevelNumbers (val value : Int) {
        LEVEL_1(3),
        LEVEL_2(4),
        LEVEL_3(6),
        LEVEL_4(8),
        LEVEL_DEF (3)
    }

}