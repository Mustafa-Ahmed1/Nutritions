package com.example.nutritionapp.ui.fragment

import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentDiabeticsScreen :BaseFragment<FragmentTopMealBinding>(){

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.top_5_diabetics_meals)

    override fun setUp() {
        binding.textInfo.text = getString(R.string.diabetics_meals_informations)
    }


}