package com.example.nutritionapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.data.model.managers.MealDataManager
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

    private var mealDataManager: Parcelable = MealDataManager()
    private lateinit var mealList: MutableList<Meal>
    private val bundle = Bundle()

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val bestMealFragment = BestMealsFragment()
    private val mealsSearchFragment = MealsSearchFragment()
    private val caloriesCounterFragment = CaloriesCounterFragment()
    private val calculateRequiredCaloriesFragment = CalculateRequiredCaloriesFragment()

    override var visibleBottomNavigationBar: Boolean = true

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.best_meals)

    override fun setUp() {
        buttonCardDiabetics()
        buttonCardGym()
        buttonCardPressure()
        buttonCardWeightLoss()
        buttonCalculateRequiredCaloriesFragment()
    }

 override fun onStart() {
        super.onStart()
        mealDataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealList = (mealDataManager as MealDataManager).getMeals()
        bundle.putParcelable(Constants.KeyValues.Meal_DATA_MANAGER, mealDataManager)
    }

    private fun buttonCardDiabetics() {
        binding.cardDiabetics.setOnClickListener {
            bundle.putString(Constants.KeyValues.BEST_MEAL_TYPE, Constants.KeyValues.DIABETICS)
            bestMealFragment.arguments = bundle
            navigationTo(bestMealFragment)
        }
    }

    private fun buttonCardGym() {
        binding.cardGym.setOnClickListener {
            bundle.putString(Constants.KeyValues.BEST_MEAL_TYPE, Constants.KeyValues.GYM)
            bestMealFragment.arguments = bundle
            navigationTo(bestMealFragment)
        }
    }


    private fun buttonCardPressure() {
        binding.cardPressure.setOnClickListener {
            bundle.putString(Constants.KeyValues.BEST_MEAL_TYPE, Constants.KeyValues.PRESSURE)
            bestMealFragment.arguments = bundle
            navigationTo(bestMealFragment)
        }
    }


    private fun buttonCardWeightLoss() {
        binding.cardWeightLoss.setOnClickListener {
            bundle.putString(Constants.KeyValues.BEST_MEAL_TYPE, Constants.KeyValues.WEIGHT_LOSS)
            bestMealFragment.arguments = bundle
            navigationTo(bestMealFragment)
        }
    }

    private fun buttonCalculateRequiredCaloriesFragment() {
        binding.calculateRequiredCalories.setOnClickListener {
            navigationTo(calculateRequiredCaloriesFragment)
        }
    }
}