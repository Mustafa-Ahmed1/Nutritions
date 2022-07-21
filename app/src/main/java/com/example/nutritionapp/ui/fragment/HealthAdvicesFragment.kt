package com.example.nutritionapp.ui.fragment

import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentHealthAdvicesBinding
import com.example.nutritionapp.ui.base.BaseFragment

class HealthAdvicesFragment : BaseFragment<FragmentHealthAdvicesBinding>() {

    override fun bindingInflater(): FragmentHealthAdvicesBinding =
        FragmentHealthAdvicesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.health_advices)

    override fun setUp() {}

}