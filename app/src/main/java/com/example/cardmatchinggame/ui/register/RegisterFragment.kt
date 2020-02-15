package com.example.cardmatchinggame.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.databinding.FragmentRegisterBinding
import com.example.cardmatchinggame.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    lateinit var registerViewModel: RegisterViewModel

    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        initUserLiveData()
        binding.registerViewModel = registerViewModel

    }

    private fun initUserLiveData() {
        registerViewModel.getUser().observe(viewLifecycleOwner, Observer {
           if (registerViewModel.isUserCorrect()){
               // intent here
           }

        })
    }

}