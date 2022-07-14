package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
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

    override var visibilityCustomActionBar: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun title(): String? {
        TODO("Not yet implemented")
    }

    override fun back(): Fragment? {
        TODO("Not yet implemented")
    }

}