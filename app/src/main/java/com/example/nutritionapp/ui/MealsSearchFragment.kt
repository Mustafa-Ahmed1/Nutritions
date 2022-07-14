package com.example.nutritionapp.ui

import android.util.Log
import android.widget.ArrayAdapter
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constant
import java.io.InputStreamReader

class MealsSearchFragment : BaseFragment<FragmentSearchMealsBinding>() {

    val parser = CSVParser()
    lateinit var mealsList: MutableList<Meal>

    override var visibilityCustomActionBar: Boolean= true
    override fun title(): String = "Search for all meals"
    override fun back(): Fragment = HomeFragment()

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override fun setUp() {
        val homeFragment = HomeFragment()
        binding.buttonBackSearchScreen.setOnClickListener {
            backNavigation(homeFragment)
        }

        openFile()

        mealsList = DataManager.getMeals()

        val finalList: MutableList<String> = mutableListOf()

        for (i in 0 until mealsList.size) {
            finalList.add(mealsList[i].name)
        }

        Log.v("MTEST", "$finalList")

        val adapter = context?.let { it1 -> ArrayAdapter(it1, com.example.nutritionapp.R.layout.drop_down_list_item, finalList) }
        binding.allMeals.setAdapter(adapter)
    }

    fun openFile() {
        val inputStream = requireActivity().assets.open(Constant.CSV_FILE_NAME)
        val buffer = InputStreamReader(inputStream)
        parser.getMealsFromCSV(buffer)
    }
}


