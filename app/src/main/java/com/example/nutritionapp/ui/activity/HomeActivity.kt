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
import com.example.nutritionapp.util.Constants
import com.example.nutritionapp.util.istVisible
import java.io.InputStreamReader

class HomeActivity : BaseActivity<ActivityMainBinding>() {

    val parser = CSVParser()
    private lateinit var dataManager: Parcelable
    private lateinit var mealsList: MutableList<Meal>

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    fun setUpCustomActionBar(visible: Boolean, title: String?, back: Fragment?) {
        if (visible) {
            binding.widgetAppAction.appAction
            binding.widgetAppAction.appActionTitle.text = title.toString()
            binding.widgetAppAction.buttonBack.setOnClickListener {
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
        mealsList = (dataManager as DataManager).getMeals()
        setDefaultMainFragment()


    }

    private fun setDefaultMainFragment() {
        val homeFragment = HomeFragment()
        val bundle = Bundle()
        bundle.putParcelable(Constants.KeyValues.DATA_MANAGER, dataManager)
        homeFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_fragment, homeFragment)
        transaction.commit()
    }

    fun openFile() {
        val inputStream = assets.open(Constants.FilePath.NUTRITION_CSV)
        val buffer = InputStreamReader(inputStream)
        dataManager = parser.getMealsFromCSV(buffer)
    }
}
