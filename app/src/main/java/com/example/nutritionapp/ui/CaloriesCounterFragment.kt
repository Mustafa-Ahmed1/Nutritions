package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.base.BaseFragment

class CaloriesCounterFragment : BaseFragment<FragmentCounterCaloriesBinding>() {

    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun getTitle(): String = getString(R.string.action_app_title_total_calories)
    override fun getBack(): Fragment = HomeFragment()

    override fun initFragment() {}

}