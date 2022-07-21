package com.example.nutritionapp.ui.fragment

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentDiabeticsScreen :BaseFragment<FragmentTopMealBinding>(){

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun getTitle(): String = getString(R.string.top_5_diabetics_meals)
    override fun back(): Fragment = HomeFragment()
    @SuppressLint("SetTextI18n")
    override fun setUp() {
        binding.textInfo.text = getString(R.string.diabetics_meals_information)
    }


}