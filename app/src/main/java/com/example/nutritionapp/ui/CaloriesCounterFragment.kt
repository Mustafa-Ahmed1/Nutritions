package com.example.nutritionapp.ui

import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.base.BaseFragment

class CaloriesCounterFragment : BaseFragment<FragmentCounterCaloriesBinding>() {

    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

    override fun setUp() {
        val homeFragment = HomeFragment()
        binding.buttonBackSearchScreen.setOnClickListener {
            backNavigation(homeFragment)
        }
    }

}