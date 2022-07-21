package com.example.nutritionapp.ui.fragment

import androidx.fragment.app.Fragment
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class MealDetailsFragment : BaseFragment<FragmentTestBinding>() {

    override fun bindingInflater(): FragmentTestBinding =
        FragmentTestBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = arguments?.getString(Constants.KeyValues.MEAL_NAME).toString()
    override fun back(): Fragment = MealsSearchFragment()

    override fun setUp() {
        val meal = arguments?.getSerializable(Constants.KeyValues.MEAL) as Meal?
        meal?.let { bindMeal(it) }
    }

    private fun bindMeal(meal: Meal) {
        binding.apply {
            caloriesValue.text = meal.calories.toString()
            sugarsValue.text = meal.sugars.toString()
            proteinsValue.text = meal.protein.toString()
            fibersValue.text = meal.fiber.toString()
        }
    }
}