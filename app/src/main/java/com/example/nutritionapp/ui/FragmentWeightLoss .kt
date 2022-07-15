package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentWeightLoss :BaseFragment<FragmentTopMealBinding>(){

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun title(): String = getString(R.string.action_app_title_Top_5_weight_losing_meals)
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {
        binding.textInfo.text = getString(R.string.info_Top_5_weight_losing_meals)
    }

}