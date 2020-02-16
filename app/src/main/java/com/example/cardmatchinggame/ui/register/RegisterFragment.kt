package com.example.cardmatchinggame.ui.register

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.base.BaseFragment
import com.example.cardmatchinggame.databinding.FragmentRegisterBinding
import com.example.cardmatchinggame.viewmodel.RegisterViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    lateinit var registerViewModel: RegisterViewModel

    lateinit var binding: FragmentRegisterBinding

    override fun onBind(binding: ViewDataBinding) {
        this.binding = binding as FragmentRegisterBinding
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding.lifecycleOwner = this
        initUserLiveData()
        binding.registerViewModel = registerViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_register
    }

    private fun initUserLiveData() {
        registerViewModel.isSuccessfulUser.observe(viewLifecycleOwner, Observer {
            if (registerViewModel.isSuccessfulUser.value!!) {
                val action = RegisterFragmentDirections.actionRegisterFragmentToMainFragment().also {
                    it.user = registerViewModel.user
                }
                findNavController(this).navigate(action)
            }
        })
    }

}