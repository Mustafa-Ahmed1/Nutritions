package com.example.nutritionapp.ui

import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.ui.base.BaseFragment

class MealsSearchFragment : BaseFragment<FragmentSearchMealsBinding>() {

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override fun setUp() {}

}