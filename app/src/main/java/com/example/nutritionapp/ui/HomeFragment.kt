package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment


class HomeFragment() :BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val diabeticsScreenFragment = FragmentDiabeticsScreen()
    private val mealsSearchFragment = MealsSearchFragment()
    private val bodyBuildingFragment = FragmentBodyBuilding()
    private val weightLossFragment = FragmentWeightLoss()
    private val caloriesCounterFragment = CaloriesCounterFragment()
    private val bloodPressureFragment = FragmentBloodPressure()

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
            navigationTo(bodyBuildingFragment)
        }
    }

    private fun buttonWeightLoss() {
        binding.cardWeightLoss.setOnClickListener {
            navigationTo(weightLossFragment)
        }
    }

    private fun buttonBloodPressure() {
        binding.cardPressure.setOnClickListener {
            navigationTo(bloodPressureFragment)
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