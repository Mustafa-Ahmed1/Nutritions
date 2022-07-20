package com.example.nutritionapp.ui.fragment

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentHealthAdvicesBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class HealthAdvicesFragment : BaseFragment<FragmentHealthAdvicesBinding>() {

    override fun bindingInflater(): FragmentHealthAdvicesBinding =
        FragmentHealthAdvicesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = arguments?.getString(Constants.KeyValues.MEAL_NAME).toString()
    override fun back(): Fragment = MealsSearchFragment()

    override fun setUp() {

    }

}