package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentBodyBuildingBinding
import com.example.nutritionapp.databinding.FragmentDiabeticsScreenBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentBodyBuilding :BaseFragment<FragmentBodyBuildingBinding>(){

    override fun bindingInflater(): FragmentBodyBuildingBinding =
        FragmentBodyBuildingBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Top 5 bodybuilding meals"
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {

    }


}