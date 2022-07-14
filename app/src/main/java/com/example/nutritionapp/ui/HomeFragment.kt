package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment


class HomeFragment() :BaseFragment<FragmentHomeBinding>() {

    private val diabeticsScreenFragment = FragmentDiabeticsScreen()
    private val mealsSearchFragment = MealsSearchFragment()
    private val caloriesCounterFragment = CaloriesCounterFragment()

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = false
    override fun title(): String? = null
    override fun back(): Fragment? = null

    override fun setUp() {
        buttonCardDiabetics()
        buttonShowAll()
        buttonCaloriesCounter()
        buttonBodyBuilding()
        buttonWeightLoss()
        buttonBloodPressure()
    }

    private fun buttonCardDiabetics() {
        binding.cardDiabetics.setOnClickListener {
            navigationTo(diabeticsScreenFragment)
        }
    }

    private fun buttonBodyBuilding() {
        binding.cardGym.setOnClickListener {
            navigationTo(diabeticsScreenFragment)
        }
    }

    private fun buttonWeightLoss() {
        binding.cardWeightLoss.setOnClickListener {
            navigationTo(diabeticsScreenFragment)
        }
    }

    private fun buttonBloodPressure() {
        binding.cardPressure.setOnClickListener {
            navigationTo(diabeticsScreenFragment)
        }
    }

    private fun buttonShowAll() {
        binding.showAll.setOnClickListener {
            navigationTo(mealsSearchFragment)
        }
    }

    private fun buttonCaloriesCounter() {
        binding.caloriesCounter.setOnClickListener {
            navigationTo(caloriesCounterFragment)
        }
    }

}