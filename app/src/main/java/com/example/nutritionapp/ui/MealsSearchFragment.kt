package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.ui.base.BaseFragment

class MealsSearchFragment : BaseFragment<FragmentSearchMealsBinding>() {

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Search for all meals"
    override fun back(): Fragment = HomeFragment()

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override fun setUp() {}

}