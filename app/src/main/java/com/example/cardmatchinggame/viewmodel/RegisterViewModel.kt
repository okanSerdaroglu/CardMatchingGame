package com.example.cardmatchinggame.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterViewModel : ViewModel() {
    private val userMutableLiveData: MutableLiveData<User> = MutableLiveData()

    var nickname: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    lateinit var mAuth : FirebaseAuth
    lateinit var firebaseUser : FirebaseUser

    fun getUser(): MutableLiveData<User> {
        return userMutableLiveData
    }

    fun onClick(view : View) {

        userMutableLiveData.value = User(nickname.value.toString(), password.value.toString())
        checkUser()
    }

    fun isUserCorrect(): Boolean {
        return false
    }

    private fun checkUser (){

        this.mAuth.createUserWithEmailAndPassword(nickname.value.toString(), password.value.toString()).addOnCompleteListener { task: Task<AuthResult> ->
            if (task.isSuccessful) {
                Log.e("succesful",nickname.value.toString())
            } else {
                Log.e("hata",nickname.value.toString())
            }
        }

    }

}




