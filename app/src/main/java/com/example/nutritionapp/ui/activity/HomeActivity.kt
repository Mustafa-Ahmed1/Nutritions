package com.example.nutritionapp.ui.activity

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.ActivityMainBinding
import com.example.nutritionapp.ui.MealAdapter
import com.example.nutritionapp.ui.fragment.HomeFragment
import com.example.nutritionapp.ui.base.BaseActivity
import com.example.nutritionapp.ui.fragment.CaloriesCounterFragment
import com.example.nutritionapp.ui.fragment.HealthAdvicesFragment
import com.example.nutritionapp.ui.fragment.MealsSearchFragment
import com.example.nutritionapp.util.Constants
import com.example.nutritionapp.util.istVisible
import java.io.InputStreamReader

class HomeActivity : BaseActivity<ActivityMainBinding>() {

    val parser = CSVParser()
    val bundle = Bundle()
    private lateinit var dataManager: Parcelable
    private lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    fun setUpCustomActionBar(visible: Boolean, title: String?, back: Fragment?) {
        if (visible) {
            binding.widgetAppAction.appAction
            binding.widgetAppAction.appActionTitle.text = title.toString()
            binding.widgetAppAction.buttonBack.setOnClickListener {
                supportFragmentManager.popBackStack()
            }
        }
        binding.widgetAppAction.root.visibility = istVisible(visible)
    }

    override fun setUp() {
        setTheme(R.style.Theme_NutritionApp)
        openFile()
        bundle.putParcelable(Constants.KeyValues.DATA_MANAGER, dataManager)
        bottomNavigationBar()
        mealsList = (dataManager as DataManager).getMeals()
        setDefaultMainFragment()
    }

    private fun setDefaultMainFragment() {
        val homeFragment = HomeFragment()
        homeFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_fragment, homeFragment)
        transaction.commit()
    }

    private fun changeNavigation(fragment: Fragment) {
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.root_fragment, fragment).addToBackStack(null)
        transaction.commit()
    }

    private fun bottomNavigationBar() {
        val homeFragment = HomeFragment()
        val mealsSearchFragment = MealsSearchFragment()
        val caloriesCounterFragment = CaloriesCounterFragment()
        val healthAdvicesFragment = HealthAdvicesFragment()

        binding.bottomNavigationBar.setOnNavigationItemSelectedListener {

            item-> when(item.itemId){
                R.id.pageHome ->{
                    changeNavigation(homeFragment)
                    true
                }
                R.id.pageSearch ->{
                    changeNavigation(mealsSearchFragment)
                    true
                }
                R.id.pageCaloriesCounter ->{
                    changeNavigation(caloriesCounterFragment)
                    true
                }
                R.id.pageHealthAdvices ->{
                    changeNavigation(healthAdvicesFragment)
                    true
                }
                else -> false
           }
        }
    }

    fun openFile() {
        val inputStream = assets.open(Constants.FilePath.NUTRITION_CSV)
        val buffer = InputStreamReader(inputStream)
        dataManager = parser.getMealsFromCSV(buffer)
    }
}
