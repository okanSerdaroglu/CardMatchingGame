package com.example.cardmatchinggame.ui.home


import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.base.BaseFragment
import com.example.cardmatchinggame.databinding.FragmentSplashBinding
import com.example.cardmatchinggame.model.User
import com.google.firebase.auth.FirebaseAuth

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun onBind(binding: ViewDataBinding) {
        val fireBaseUser = FirebaseAuth.getInstance().currentUser
        if (fireBaseUser != null) {
            val user = fireBaseUser.email?.let { User(it, "") }
            val action = SplashFragmentDirections.actionSplashFragmentToMainFragment().also {
                it.user = user
            }
            findNavController(this).navigate(action)
        } else {
            findNavController(this).navigate(SplashFragmentDirections.actionSplashFragmentToRegisterFragment())
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }
}