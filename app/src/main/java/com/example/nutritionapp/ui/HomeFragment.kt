package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment


class HomeFragment() :BaseFragment<FragmentHomeBinding>() {
    private val diabeticsScreenFragment: FragmentDiabeticsScreen = FragmentDiabeticsScreen()

    override fun bindingInflater(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = false
    override fun title(): String? = null
    override fun back(): Fragment? = null

    override fun setUp() {
        buttonCardDiabetics()
    }

    private fun buttonCardDiabetics() {
        binding.cardDiabetics.setOnClickListener{
            navigationTo(diabeticsScreenFragment)
        }
    }


}