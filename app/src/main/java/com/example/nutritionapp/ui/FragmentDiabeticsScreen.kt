package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentDiabeticsScreenBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentDiabeticsScreen :BaseFragment<FragmentDiabeticsScreenBinding>(){

    override fun bindingInflater(): FragmentDiabeticsScreenBinding =
        FragmentDiabeticsScreenBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Top 5 diabetes meals"
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {

        val _homeFragment = HomeFragment()
        binding.buttonBack.setOnClickListener {
            backNavigation(_homeFragment)
        }
    }

}