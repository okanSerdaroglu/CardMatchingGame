package com.example.cardmatchinggame.viewmodel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardmatchinggame.model.User
import com.google.firebase.auth.*

class RegisterViewModel : ViewModel() {

    lateinit var user: User

    var nickname = String()
    var password = String()

    var isSuccessfulUser: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onClickRegister(view: View) {
        checkUser(view)
    }

    private fun checkUser(view: View) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(nickname, password)
            .addOnSuccessListener {
                user = User(nickname, "")
                isSuccessfulUser.value = true
            }.addOnFailureListener {
                if ((it as FirebaseAuthUserCollisionException).errorCode == "ERROR_EMAIL_ALREADY_IN_USE") {
                    user = User(nickname, "")
                    isSuccessfulUser.value = true
                } else {
                    Toast.makeText(view.context, it.message, Toast.LENGTH_LONG).show()
                }
            }
    }

}