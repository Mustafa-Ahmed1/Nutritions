package com.example.nutritionapp.ui.fragment

import androidx.fragment.app.Fragment
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentHealthAdvicesBinding
import com.example.nutritionapp.ui.base.BaseFragment

class HealthAdvicesFragment : BaseFragment<FragmentHealthAdvicesBinding>() {

    override fun bindingInflater(): FragmentHealthAdvicesBinding =
        FragmentHealthAdvicesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = getString(R.string.health_advices)
    override fun back(): Fragment = MealsSearchFragment()

    override fun setUp() {

    }

}