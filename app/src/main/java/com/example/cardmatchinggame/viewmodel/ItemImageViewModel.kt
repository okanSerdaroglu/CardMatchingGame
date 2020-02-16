package com.example.cardmatchinggame.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.helper.interfaces.IBoxSelected
import com.example.cardmatchinggame.model.Box

class ItemImageViewModel(var box : Box,var position : Int) : ViewModel() {

    lateinit var iBoxSelected : IBoxSelected

    fun changeState() {
        if (isBoxTurned.value == true){
            return
        } else {
            isBoxTurned.value = true
        }

        //isBoxTurned.value = isBoxTurned.value != true
        iBoxSelected.onBoxSelected(this)
    }

    var isBoxTurned : MutableLiveData<Boolean> = MutableLiveData(false)
}
