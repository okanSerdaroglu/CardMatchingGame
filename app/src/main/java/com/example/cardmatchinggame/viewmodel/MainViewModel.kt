package com.example.cardmatchinggame.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.model.User

class MainViewModel : ViewModel() {

    lateinit var user : User

    // Image
    var avatarPath : MutableLiveData<String> = MutableLiveData()

    var isPlayClicked : MutableLiveData<Boolean> = MutableLiveData(false)
    var isLeadersClicked : MutableLiveData<Boolean> = MutableLiveData(false)
    var isAvatarClicked : MutableLiveData<Boolean> = MutableLiveData(false)

    fun avatarClicked(view : View) {
        isAvatarClicked.value = true
    }

    fun playClicked(view : View) {
        isPlayClicked.value = true
    }

    fun leadersClicked(view : View) {
        isLeadersClicked.value = true
    }
}