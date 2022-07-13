package com.example.nutritionapp.ui

import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {}

}