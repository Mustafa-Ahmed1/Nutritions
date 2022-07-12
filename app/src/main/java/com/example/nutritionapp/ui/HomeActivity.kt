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

    val parser = CSVParser()
    private val calculation: Calculation = Calculation()
    lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    override fun setUp() {
        findViewById<View>(R.id.widget_app_action).visibility = View.GONE
        binding.button.visibility = View.VISIBLE
        navigate()

        openFile()
        mealsList = DataManager.getMeals()
    }

    private fun navigate() {
        binding.button.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.root_fragment, homeFragment)
            transaction.commit()
        }
    }

    fun openFile() {
        val inputStream = assets.open(Constant.CSV_FILE_NAME)
        val buffer = InputStreamReader(inputStream)
        parser.getMealsFromCSV(buffer)
    }
}

