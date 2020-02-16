package com.example.cardmatchinggame.helper

import com.example.cardmatchinggame.model.User
import com.example.cardmatchinggame.viewmodel.MainViewModel

class MainFragmentUtils {
    companion object {
        fun getMainViewModel(user : User, mainViewModel: MainViewModel) {
            mainViewModel.user = user
        }
    }
}