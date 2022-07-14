package com.example.nutritionapp

import com.example.nutritionapp.data.model.Meal

class Calculation {
    fun calculateCustomGramsCalories(caloriesOf100g: Double, mealGrams: Double) =
        if (mealGrams <= 0 || caloriesOf100g <= 0) 0.0 else (mealGrams / 100.0) * caloriesOf100g
    //  var cal = calculation.calculateCustomGramsCalories(mealsList[0].calories, 250.0)

    fun getListByMealName(mealName: String, mealList: List<Meal>): Meal? {
        mealList.forEach {
            if (it.name == mealName) return it
        }
        return null
    }
}