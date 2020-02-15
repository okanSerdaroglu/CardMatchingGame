package com.example.cardmatchinggame.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.helper.interfaces.IBoxSelected
import com.example.cardmatchinggame.model.Box

class ItemImageViewModel(var box : Box,var position : Int) : ViewModel() {

    lateinit var iBoxSelected : IBoxSelected

    fun changeState() {
        isBoxTurned.value = isBoxTurned.value != true

    }

    fun setListener (iBoxSelected: IBoxSelected){
        this.iBoxSelected = iBoxSelected
    }

    var isBoxTurned : MutableLiveData<Boolean> = MutableLiveData(false)
}
