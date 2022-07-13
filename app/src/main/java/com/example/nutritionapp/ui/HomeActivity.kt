package com.example.nutritionapp.ui

import android.view.View
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.Calculation
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.ActivityMainBinding
import com.example.nutritionapp.ui.base.BaseActivity
import com.example.nutritionapp.util.Constant
import java.io.InputStreamReader

class HomeActivity : BaseActivity<ActivityMainBinding>() {

    private val homeFragment: HomeFragment = HomeFragment()
    private val mealsSearchFragment: MealsSearchFragment = MealsSearchFragment()

    val parser = CSVParser()
    private val calculation: Calculation = Calculation()
    lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    override fun setUp() {
        binding.widgetAppAction.root.visibility = View.GONE
        openFile()
        mealsList = DataManager.getMeals()
        setDefaultMainFragment()
    }

    private fun setDefaultMainFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_fragment, homeFragment)
        transaction.commit()
    }

    fun openFile() {
        val inputStream = assets.open(Constant.CSV_FILE_NAME)
        val buffer = InputStreamReader(inputStream)
        parser.getMealsFromCSV(buffer)
    }
}

