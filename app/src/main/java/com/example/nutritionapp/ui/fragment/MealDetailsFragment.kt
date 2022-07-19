package com.example.nutritionapp.ui.fragment

import android.graphics.Color
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.FragmentMealDetailsBinding
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class MealDetailsFragment : BaseFragment<FragmentMealDetailsBinding>() {

    override fun bindingInflater(): FragmentMealDetailsBinding =
        FragmentMealDetailsBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = arguments?.getString(Constants.KeyValues.MEAL_NAME).toString()
    override fun back(): Fragment = MealsSearchFragment()

    override fun setUp() {
        val meal = arguments?.getSerializable(Constants.KeyValues.MEAL) as Meal?
         lateinit var lineDataSet: LineDataSet
         lateinit var linelist:ArrayList<Entry>
         lateinit var lineData: LineData
        var pc: PieChart? = null
//        pc = findViewById(R.id.meal_Line_chart);
        pc = binding.mealLineChart;
        val pieData: ArrayList<PieEntry> = ArrayList()
        pieData.add(PieEntry(10f))
        pieData.add(PieEntry(20f))
        pieData.add(PieEntry(30f))
        val dataSet = PieDataSet(pieData, "Survey Results")
        val data = PieData(dataSet)
        pc!!.data = data
        dataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        dataSet.valueTextColor = Color.BLUE
        dataSet.valueTextSize = 20f

        meal?.let { bindMeal(it) }
    }

    private fun bindMeal(meal: Meal) {
        binding.apply {
//            caloriesValue.text = meal.calories.toString()
//            sugarsValue.text = meal.sugars.toString()
//            proteinsValue.text = meal.protein.toString()
//            fibersValue.text = meal.fiber.toString()
        }
    }

    override fun onStart() {
        super.onStart()
    }

}