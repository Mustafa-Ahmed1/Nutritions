package com.example.nutritionapp.ui.fragment

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val diabeticsScreenFragment = FragmentDiabeticsScreen()
    private val mealsSearchFragment = MealsSearchFragment()
    private val caloriesCounterFragment = CaloriesCounterFragment()

    override var visibilityCustomActionBar: Boolean = false
    override fun getTitle(): String? = null
    override fun back(): Fragment? = null

    override fun setUp() {
        buttonCardDiabetics()
        buttonShowAll()
        buttonCaloriesCounter()
    }

    private fun buttonCardDiabetics() {
        binding.cardDiabetics.setOnClickListener {
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