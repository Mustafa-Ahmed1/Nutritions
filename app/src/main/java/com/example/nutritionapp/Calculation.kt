package com.example.nutritionapp

import android.util.Log
import com.example.nutritionapp.data.model.Meal

class Calculation {
    fun calculateCustomGramsCalories(caloriesOf100g: Double, mealGrams: Double) =
        if (mealGrams <= 0 || caloriesOf100g <= 0) 0.0 else (mealGrams / 100.0) * caloriesOf100g
    //  var cal = calculation.calculateCustomGramsCalories(mealsList[0].calories, 250.0)

    fun bloodPressureBest5Meals(mealsList: MutableList<Meal>){
        var resultMap: MutableMap<Int,Double> = mutableMapOf()
        mealsList.forEachIndexed { index, meal ->
            val result = (meal.sodium * -1) + (meal.totalFat * -1) + (meal.calcium) + (meal.fiber * 0.7)
            resultMap.put(index, result)
        }
        val sortedResultMap = resultMap.toList().sortedByDescending { (_, value) -> value}.toMap()
        val best5Meals = sortedResultMap.keys.toList().subList(0,5)
        Log.v("ABC", best5Meals.toString())
    }
}