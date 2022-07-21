package com.example.nutritionapp.ui.fragment

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.FragmentMealDetailsBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*


class MealDetailsFragment : BaseFragment<FragmentMealDetailsBinding>() {

    override fun bindingInflater(): FragmentMealDetailsBinding =
        FragmentMealDetailsBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = true
    override fun getTitle(): String = (arguments?.getSerializable(Constants.KeyValues.MEAL) as Meal).name

    override fun setUp() {
        val meal = arguments?.getSerializable(Constants.KeyValues.MEAL) as Meal?
        var piechart: PieChart? = null
        piechart = binding.mealLineChart;
        val pieData: ArrayList<PieEntry> = ArrayList()
        pieData.add(PieEntry( meal!!.fiber.toFloat() ))
        pieData.add(PieEntry(meal!!.sugars.toFloat() ))
        pieData.add(PieEntry(meal!!.totalFat.toFloat() ))
        pieData.add(PieEntry(meal!!.protein.toFloat() ))
        val dataSet = PieDataSet(pieData, "" )
        dataSet.sliceSpace = 7f
        val data = PieData(dataSet)
        data.setDrawValues(false)
        piechart.holeRadius = 90f
        piechart.setDrawRoundedSlices(true)
        piechart.description.isEnabled = false    // Hide the description
        piechart.legend.isEnabled = false
        piechart.data = data

        val MY_COLORS = intArrayOf(
            Color.rgb(173, 83, 148),
            Color.rgb(133, 182, 255),
            Color.rgb(235, 87, 87),
            Color.rgb(226, 195, 101)
        )
        val colors = ArrayList<Int>()
        for (c in MY_COLORS) colors.add(c)
        dataSet.colors = colors

        dataSet.valueTextColor = Color.BLUE
        dataSet.valueTextSize = 20f
        meal?.let { bindMeal(it) }
    }

    private fun bindMeal(meal: Meal) {
        binding.apply {
            caloriesValue.text = meal.calories.toInt().toString()
            fabricQuantity.text = meal.fiber.toString()
            sugarQuantity.text = meal.sugars.toString()
            proteinQuantity.text = meal.protein.toString()
            fatQuantity.text = meal.totalFat.toString()
        }
    }

}