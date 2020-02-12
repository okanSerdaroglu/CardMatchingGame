package com.example.cardmatchinggame

import androidx.databinding.ViewDataBinding
import com.example.cardmatchinggame.base.BaseFragment
import com.example.cardmatchinggame.databinding.FragmentLeadersBinding

class LeadersFragment : BaseFragment<FragmentLeadersBinding>() {
    lateinit var binding: FragmentLeadersBinding

    override fun onBind(binding: ViewDataBinding) {
        this.binding = binding as FragmentLeadersBinding
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_leaders
    }

}