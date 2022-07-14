package com.example.nutritionapp.ui

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.Calculation
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.ActivityMainBinding
import com.example.nutritionapp.ui.base.BaseActivity
import com.example.nutritionapp.util.Constant
import com.example.nutritionapp.util.istVisible
import java.io.InputStreamReader

class HomeActivity : BaseActivity<ActivityMainBinding>() {

    val parser = CSVParser()
    private val calculation: Calculation = Calculation()
    lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)
    fun setUpCustomActionBar(visible: Boolean,title: String?, back: Fragment?){
        if (visible){
            binding.widgetAppAction.appActionTitle.text = title
            binding.widgetAppAction.buttonBack.setOnClickListener{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.root_fragment, back!!)
                transaction.commit()
            }
        }
        binding.widgetAppAction.root.visibility = istVisible(visible)
    }
    override fun setUp() {
        setTheme(R.style.Theme_NutritionApp)
        openFile()
        mealsList = DataManager.getMeals()
        val calculation = Calculation()
        calculation.bloodPressureBest5Meals(mealsList)
        setDefaultMainFragment()
        val rr=Calculation().mealTop5(mealsList,5)
//        Log.v("AMEER", "${rr[3].name}")
    }

    private fun setDefaultMainFragment() {
        val homeFragment: HomeFragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_fragment, HomeFragment())
        transaction.commit()
    }

    fun openFile() {
        val inputStream = assets.open(Constant.CSV_FILE_NAME)
        val buffer = InputStreamReader(inputStream)
        parser.getMealsFromCSV(buffer)
    }
}
