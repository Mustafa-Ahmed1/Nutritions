package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentDiabeticsScreenBinding
import com.example.nutritionapp.ui.base.BaseFragment

class FragmentWeightLoss :BaseFragment<FragmentDiabeticsScreenBinding>(){

    override fun bindingInflater(): FragmentDiabeticsScreenBinding =
        FragmentDiabeticsScreenBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Top 5 weight losing meals"
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {
        
    }


}