package com.example.nutritionapp.ui

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentDiabeticsScreen :BaseFragment<FragmentTopMealBinding>(){

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = getString(R.string.action_app_title_Top_5_diabetes_meals)
    override fun getBack(): Fragment = HomeFragment()

    override fun initFragment() {
        binding.textInfo.text = getString(R.string.info_Top_5_diabetes_meals)
    }

}