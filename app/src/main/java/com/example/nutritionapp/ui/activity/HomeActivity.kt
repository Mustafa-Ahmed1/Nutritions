package com.example.nutritionapp.ui.activity

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.nutritionapp.util.parsers.CSVParser
import com.example.nutritionapp.R
import com.example.nutritionapp.data.dataManager.MealDataManager
import com.example.nutritionapp.data.local.LocalStorage
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.ActivityMainBinding
import com.example.nutritionapp.ui.fragment.HomeFragment
import com.example.nutritionapp.ui.base.BaseActivity
import com.example.nutritionapp.ui.fragment.CaloriesCounterFragment
import com.example.nutritionapp.ui.fragment.HealthAdvicesFragment
import com.example.nutritionapp.ui.fragment.MealsSearchFragment
import com.example.nutritionapp.util.Constants
import com.example.nutritionapp.util.istVisible
import com.example.nutritionapp.util.parsers.CSVParserHealthAdvice
import java.io.InputStreamReader

@Suppress("DEPRECATION")
class HomeActivity : BaseActivity<ActivityMainBinding>() {

    private val maelParser = CSVParser()
    private val healthAdviceParser = CSVParserHealthAdvice()
    val bundle = Bundle()
    private lateinit var dataManager: Parcelable
    private lateinit var healthAdviceDataManger: Parcelable
    private lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    fun setUpCustomActionBar(
        visibleActionBar: Boolean,
        visibilityBackButton: Boolean,
        title: String?,
        visibleBottomNavigationBar: Boolean
    ) {
        if (visibleActionBar) {
            binding.widgetAppAction.appActionTitle.text = title.toString()
            binding.widgetAppAction.buttonBack.setOnClickListener {
                supportFragmentManager.popBackStack()
            }
        }

        binding.widgetAppAction.root.visibility = istVisible(visibleActionBar)
        binding.widgetAppAction.buttonBack.visibility = istVisible(visibilityBackButton)
        binding.bottomNavigationBar.visibility = istVisible(visibleBottomNavigationBar)
    }

    override fun setUp() {
        setTheme(R.style.Theme_NutritionApp)

        val localStorage = LocalStorage(applicationContext)
        localStorage.put<String>(Constants.Data.LocalStorage.MY_DATA,"Hello from local storage")

        Log.v("ADD", openFile(Constants.FilePath.NUTRITION_CSV).toString())
        dataManager = maelParser.getMealsFromCSV(openFile(Constants.FilePath.NUTRITION_CSV))
        Log.v("BDD", openFile(Constants.FilePath.HEALTH_ADVICES_CSV).toString())
        healthAdviceDataManger = healthAdviceParser.getHealthAdvicesFromCSV(openFile(Constants.FilePath.HEALTH_ADVICES_CSV))
        Log.v("ASD", healthAdviceDataManger.toString())
        bundle.putParcelable(Constants.KeyValues.Meal_DATA_MANAGER, dataManager)
        mealsList = (dataManager as MealDataManager).getMeals()
        setDefaultMainFragment()

        localStorage.get<String>(Constants.Data.LocalStorage.MY_DATA)
    }

    override fun onStart() {
        super.onStart()
        bottomNavigationBar()
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
                    bundle.putParcelable(Constants.KeyValues.HEALTH_ADVICE_DATA_MANAGER, healthAdviceDataManger)
                    changeNavigation(healthAdvicesFragment)
                    true
                }
                else -> false
           }
        }
    }

    fun openFile(filePath: String): InputStreamReader {
        val inputStream = assets.open(filePath)
        Log.v("XDD", inputStream.toString())
        return InputStreamReader(inputStream)
    }
}
