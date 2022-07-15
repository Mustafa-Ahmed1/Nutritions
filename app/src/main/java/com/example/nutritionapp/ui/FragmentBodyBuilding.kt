package com.example.nutritionapp.ui

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentBodyBuilding :BaseFragment<FragmentTopMealBinding>(){

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun title(): String = getString(R.string.action_app_title_Top_5_bodybuilding_meals)
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {
        binding.textInfo.text = getString(R.string.info_Top_5_bodybuilding_meals)
    }

}