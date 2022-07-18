package com.example.nutritionapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ArrayAdapter
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import androidx.fragment.app.Fragment
import com.example.nutritionapp.`interface`.MealInteractionListener
import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.MealAdapter
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants
import java.io.InputStreamReader
import java.io.Serializable

class MealsSearchFragment : BaseFragment<FragmentSearchMealsBinding>(), MealInteractionListener {

    private var dataManager: Parcelable = DataManager()
    private lateinit var mealsList: MutableList<Meal>
    private var mealDetailsFragment = MealDetailsFragment()

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = getString(R.string.search_for_all_meals)
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {

    }

    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()

        val adapter = MealAdapter(mealsList, this)
        binding.recyclerMeal.adapter = adapter
    }

    override fun onClickItem(meal: Meal) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.KeyValues.MEAL,meal)
        mealDetailsFragment.arguments = bundle
        navigationTo(mealDetailsFragment)
    }
}


