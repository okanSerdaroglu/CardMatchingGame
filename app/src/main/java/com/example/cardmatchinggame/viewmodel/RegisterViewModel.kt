package com.example.cardmatchinggame.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.model.User

class RegisterViewModel : ViewModel() {
    private val userMutableLiveData: MutableLiveData<User> = MutableLiveData()

    var nickname: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()

    fun getUser(): MutableLiveData<User> {
        return userMutableLiveData
    }

    fun onClick(view: View) {

        userMutableLiveData.value = User(nickname.value.toString(), password.value.toString())
    }

    fun isUserCorrect(): Boolean {
        return false
    }





}