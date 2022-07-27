package com.example.nutritionapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.`interface`.MealInteractionListener
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.data.dataManager.MealDataManager
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

    private var titleFragment: String = ""

    override var visibilityCustomActionBar: Boolean= true
    override var visibilityBackButton: Boolean = true
    override fun getTitle(): String = titleFragment

    override var visibleBottomNavigationBar: Boolean = false

    override fun setUp() {
        mealDataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (mealDataManager as MealDataManager).getMeals()
        val bestMealType =  requireNotNull(arguments?.getString(Constants.KeyValues.BEST_MEAL_TYPE))
        binding.textInfo.text = getString(R.string.diabetics_meals_information)
        var newMealList: MutableList<Meal> = mutableListOf()

        when (bestMealType){
            Constants.KeyValues.DIABETICS -> {
                newMealList = calculations.diabeticsBestMeals(mealsList, 100) as MutableList<Meal>
                setTextBestMealsFragment(R.string.best_diabetes_meals,R.string.info_diabetes_meals)
            }
            Constants.KeyValues.GYM -> {
                newMealList = calculations.bodyBuildingBestMeals(mealsList, 100) as MutableList<Meal>
                setTextBestMealsFragment(R.string.best_bodybuilding_meals,R.string.info_bodybuilding_meals)
            }
            Constants.KeyValues.PRESSURE -> {
                newMealList = calculations.bloodPressureBestMeals(mealsList, 100) as MutableList<Meal>
                setTextBestMealsFragment(R.string.best_blood_pressure_meals,R.string.info_blood_pressure_meals)
            }
            Constants.KeyValues.WEIGHT_LOSS -> {
                newMealList = calculations.weightLossBestMeals(mealsList, 100) as MutableList<Meal>
                setTextBestMealsFragment(R.string.best_weight_losing_meals,R.string.info_weight_losing_meals)
            }
        }

        adapter = MealAdapter(newMealList, this)
        binding.recyclerMeal.adapter = adapter
    }


    private fun setTextBestMealsFragment(title: Int, Info: Int){
        titleFragment = getString(title)
        binding.textInfo.text = getString(Info)
    }

    override fun onClickItem(meal: Meal) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.KeyValues.MEAL,meal)
        mealDetailsFragment.arguments = bundle
        navigationTo(mealDetailsFragment)
    }
}