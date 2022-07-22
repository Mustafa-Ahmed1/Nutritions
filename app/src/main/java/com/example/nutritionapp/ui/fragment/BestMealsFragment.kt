package com.example.nutritionapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.`interface`.MealInteractionListener
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.data.model.managers.MealDataManager
import com.example.nutritionapp.databinding.FragmentTopMealBinding
import com.example.nutritionapp.ui.MealAdapter
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class BestMealsFragment :BaseFragment<FragmentTopMealBinding>(), MealInteractionListener {

    private lateinit var adapter: MealAdapter
    private var mealDataManager: Parcelable = MealDataManager()
    private lateinit var mealsList: MutableList<Meal>
    private val mealDetailsFragment = MealDetailsFragment()
    private val calculations = Calculations()

    override fun bindingInflater(): FragmentTopMealBinding =
        FragmentTopMealBinding.inflate(layoutInflater)

    var nameee = ""
    override var visibilityCustomActionBar: Boolean= true
    override var visibilityBackButton: Boolean = true
    override fun getTitle(): String = nameee

    override var visibleBottomNavigationBar: Boolean = false

    override fun setUp() {
        mealDataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (mealDataManager as MealDataManager).getMeals()
        val bestMealType =  requireNotNull(arguments?.getString(Constants.KeyValues.BEST_MEAL_TYPE))
        binding.textInfo.text = getString(R.string.diabetics_meals_information)
        var newMealList: MutableList<Meal> = mutableListOf()
        Log.v("HHG", bestMealType)
        when (bestMealType){
            Constants.KeyValues.DIABETICS -> {
                newMealList = calculations.diabeticsBestMeals(mealsList, 100) as MutableList<Meal>
                nameee = "Diabetics top meals"
                binding.textInfo.text = "Here are the top 100 meals for diabetics. it based on specific calculations, witch contains sugar, carbohydrate, potassium and fiber."
            }
            Constants.KeyValues.GYM -> {
                newMealList = calculations.bodyBuildingBestMeals(mealsList, 100) as MutableList<Meal>
                nameee = "Bodybuilding top meals"
                binding.textInfo.text = "Here are the top 100 meals for bodybuilders. it based on specific calculations, witch contains protein, total fat and carbohydrate."
            }
            Constants.KeyValues.PRESSURE -> {
                newMealList = calculations.bloodPressureBestMeals(mealsList, 100) as MutableList<Meal>
                nameee = "Blood pressure top meals"
                binding.textInfo.text = "Here are the top 100 meals for blood pressure. it based on specific calculations, witch contains calcium, fiber, sodium and total fat."
            }
            Constants.KeyValues.WEIGHT_LOSS -> {
                newMealList = calculations.weightLossBestMeals(mealsList, 100) as MutableList<Meal>
                nameee = "Overweight top meals"
                binding.textInfo.text = "Here are the top 100 meals for Weight losing. it based on specific calculations, witch contains protein, total fat and carbohydrate."
            }
        }

        adapter = MealAdapter(newMealList, this)
        binding.recyclerMeal.adapter = adapter
    }

    override fun onClickItem(meal: Meal) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.KeyValues.MEAL,meal)
        mealDetailsFragment.arguments = bundle
        navigationTo(mealDetailsFragment)
    }
}