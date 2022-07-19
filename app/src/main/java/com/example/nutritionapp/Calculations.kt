package com.example.nutritionapp

import android.util.Log
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.util.Constants

class Calculations {

    fun calculateCustomGramsCalories(caloriesOf100g: Double, mealGrams: Double) =
        if (mealGrams <= 0 || caloriesOf100g <= 0) 0.0 else (mealGrams / 100.0) * caloriesOf100g

    fun calculatePersonDataCalories(gender: Char, weight: Double, height: Double, age: Double) =
        when (gender) {
            Constants.KeyValues.MALE -> 66.0 + (13.7 * weight) + (5.0 * height) - (6.8 * age)
            Constants.KeyValues.FEMALE -> 665.0 + (9.6 * weight) + (1.8 * height) - (4.7 * age)
            else -> null
        }

    fun getMealListByMealSubName(mealSubName: String, mealList: List<Meal>) = mealList.filter { it.name.startsWith(mealSubName) }

    fun getListByMealName(mealName: String, mealList: List<Meal>): Meal? {
        mealList.forEach {
            if (it.name == mealName) return it
        }
        return null
    }

    fun diabeticsBestMeals(mealsList: MutableList<Meal>, top: Int): List<Meal>? {
        if (mealsList.isEmpty()|| top<0||top>mealsList.size) return null
        mealsList.sortByDescending {
            it.potassium + 0.7 * it.carbohydrate + 0.5 * it.fiber - it.sugars
        }
        return mealsList.take(top)
    }

    fun bodyBuildingBestMeals(mealsList: MutableList<Meal>, top: Int): List<Meal>? {
        if (mealsList.isEmpty()|| top<0||top>mealsList.size) return null
        mealsList.sortByDescending {
            0.4 * it.protein + 0.15 * it.totalFat + 0.45 * it.carbohydrate
        }
        return mealsList.take(top)
    }

    fun cuttingBestMeals(mealsList: MutableList<Meal>, top: Int): List<Meal>? {
        if (mealsList.isEmpty()|| top<0||top>mealsList.size) return null
        mealsList.sortByDescending {
            0.5 * it.protein + 0.2 * it.totalFat + 0.3 * it.carbohydrate
        }
        return mealsList.take(top)
    }

    fun bloodPressureBestMeals(mealsList: MutableList<Meal>, top: Int): List<Meal>? {
        if (mealsList.isEmpty()|| top<0||top>mealsList.size) return null
        mealsList.sortByDescending {
            it.calcium + 0.7 * it.fiber - it.sodium - it.totalFat
        }
        return mealsList.take(top)
    }

}

//  var cal = calculation.calculateCustomGramsCalories(mealsList[0].calories, 250.0)

//val bloodPressureList = calculation.bloodPressureBestFifeMeals(mealsList, 5)
//Log.v("bloodPressure", "${bloodPressureList[0].name}")
//
//val diabeticsList = Calculation().diabeticsBestFifeMeals(mealsList, 5)
//Log.v("diabetics", "${diabeticsList[0].name}")
//val bodyBuildingList = Calculation().bodyBuildingBestFifeMeals(mealsList, 5)
//Log.v("bodyBuilding", "${bodyBuildingList[0].name}")
//val cuttingList = Calculation().cuttingBestFifeMeals(mealsList, 5)
//Log.v("cutting", "${cuttingList[0].name}")