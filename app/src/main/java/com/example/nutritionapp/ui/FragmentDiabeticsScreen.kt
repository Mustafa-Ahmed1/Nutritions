package com.example.nutritionapp.ui

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentDiabeticsScreen :BaseFragment<FragmentTopMealBinding>(){

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Top 5 diabetes meals"
    override fun back(): Fragment = HomeFragment()
    @SuppressLint("SetTextI18n")
    override fun setUp() {
        binding.textInfo.text = "The most important elements that directly affect diabetic patients: potassium, carbohydrates, sugar, fiber."
    }


}