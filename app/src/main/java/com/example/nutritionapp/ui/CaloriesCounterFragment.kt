package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.base.BaseFragment

class CaloriesCounterFragment : BaseFragment<FragmentCounterCaloriesBinding>() {

    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Total calories"
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {
    }



}