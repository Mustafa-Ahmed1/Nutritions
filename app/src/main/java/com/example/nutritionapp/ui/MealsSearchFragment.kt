package com.example.nutritionapp.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.Calculation
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constant
import java.io.InputStreamReader

class MealsSearchFragment : BaseFragment<FragmentSearchMealsBinding>() {

    lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Search for all meals"
    override fun back(): Fragment = HomeFragment()

    override fun setUp() {
        val homeFragment = HomeFragment()
        mealsList = DataManager.getMeals()

        binding.buttonBackSearchScreen.setOnClickListener {
            backNavigation(homeFragment)
        }

        val buffer = openFile(Constant.CSV_FILE_NAME)
        CSVParser().getMealsFromCSV(buffer)

        val mealsNamesList: MutableList<String> = mutableListOf()
        makeListOfMealNames(mealsNamesList, mealsList)
        setListAdapter(mealsNamesList)

        initViews()
    }

    fun openFile(fileName: String): InputStreamReader {
        val inputStream = requireActivity().assets.open(fileName)
        return InputStreamReader(inputStream)
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

            val result = Calculation().getListByMealName(mealName, mealsList)

            val testFragment = TestFragment()

            bundleOfMealsDetailsScreen(result, testFragment)

            backNavigation(testFragment)
        }
    }

    private fun bundleOfMealsDetailsScreen(
        meal: Meal?,
        fragment: BaseFragment<FragmentTestBinding>
    ) {
        val bundle = Bundle()
        with(Constant.KeyValues) {
            bundle.putString(MEAL_NAME, meal?.name)
            bundle.putString(CAL_NUMBER, meal?.calories.toString())
            bundle.putString(SUGAR_NUMBER, meal?.sugars.toString())
            bundle.putString(FIBER_NUMBER, meal?.fiber.toString())
            bundle.putString(PROTEIN_NUMBER, meal?.protein.toString())
        }
        fragment.arguments = bundle
    }

}


