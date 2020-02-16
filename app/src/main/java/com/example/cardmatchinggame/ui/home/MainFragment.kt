package com.example.cardmatchinggame.ui.home

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.cardmatchinggame.R
import com.example.cardmatchinggame.base.BaseFragment
import com.example.cardmatchinggame.databinding.FragmentMainBinding
import com.example.cardmatchinggame.helper.MainFragmentUtils
import com.example.cardmatchinggame.model.User
import com.example.cardmatchinggame.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {


    private lateinit var binding: FragmentMainBinding
    private var mainViewModel = MainViewModel()

    val user: User? by lazy {
        arguments?.let {
            MainFragmentArgs.fromBundle(it).user
        }
    }

    override fun onBind(binding: ViewDataBinding) {
        this.binding = binding as FragmentMainBinding
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.lifecycleOwner = this

        user?.let {
            MainFragmentUtils.getMainViewModel(it, mainViewModel)
        }

        binding.mainViewModel = mainViewModel

        observePlayClicked()
        observeLeaders()
        observeAvatarClicked()
    }

    private fun observeAvatarClicked() {
        mainViewModel.isAvatarClicked.observe(viewLifecycleOwner, Observer {
            if (mainViewModel.isAvatarClicked.value!!) {
                openAvatarDialog()
            }
        })
    }

    private fun openAvatarDialog() {

    }

    private fun observeLeaders() {
        mainViewModel.isLeadersClicked.observe(viewLifecycleOwner, Observer {
            if (mainViewModel.isLeadersClicked.value!!) {
                val action = MainFragmentDirections.actionMainFragmentToLeadersFragment()
                findNavController(this).navigate(action)
            }
        })
    }

    private fun observePlayClicked() {
        mainViewModel.isPlayClicked.observe(viewLifecycleOwner, Observer {
            if (mainViewModel.isPlayClicked.value!!) {
                val action = MainFragmentDirections.actionMainFragmentToPlaygroundFragment()
                findNavController(this).navigate(action)
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }
}