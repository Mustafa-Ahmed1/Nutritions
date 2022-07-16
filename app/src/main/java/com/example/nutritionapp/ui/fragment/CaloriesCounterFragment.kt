package com.example.nutritionapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class CaloriesCounterFragment : BaseFragment<FragmentCounterCaloriesBinding>() {
    private lateinit var dataManager: Parcelable
    private lateinit var mealsList: MutableList<Meal>
    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

        override var visibilityCustomActionBar: Boolean= true
        override fun getTitle(): String = getString(R.string.total_calories)
        override fun back(): Fragment = HomeFragment()

    override fun setUp() {

    }

    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()
        val mealsNamesList: MutableList<String> = mutableListOf()
        makeListOfMealNames(mealsNamesList, mealsList)
        setListAdapter(mealsNamesList)
        initViews()
    }

    private fun makeListOfMealNames(mealsNamesList: MutableList<String>, mealsList: List<Meal>) {
        for (element in mealsList) {
            mealsNamesList.add(element.name)
        }
    }

    private fun setListAdapter(list: MutableList<String>) {
        val adapter =
            context?.let { it1 -> ArrayAdapter(it1, R.layout.drop_down_list_item, list) }
        binding.allMeals.setAdapter(adapter)
    }

    private fun initViews() {
        binding.allMeals.setOnItemClickListener { _, _, _, _ ->
            val mealName = binding.allMeals.text.toString()

            val result = Calculations().getListByMealName(mealName, mealsList)


        }
    }




}