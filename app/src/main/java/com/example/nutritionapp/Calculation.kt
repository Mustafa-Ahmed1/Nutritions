package com.example.nutritionapp

class Calculation {
    fun calculateCustomGramsCalories(caloriesOf100g: Double, mealGrams: Double) = (mealGrams / 100.0) * caloriesOf100g
}

//  var cal = calculation.calculateCustomGramsCalories(mealsList[0].calories, 250.0)