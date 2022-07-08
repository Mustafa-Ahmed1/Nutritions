package com.example.nutritionapp

import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.util.Constant
import java.io.File

class CSVParser {
    public fun getMealsFromCSV(file: File){
        file.forEachLine {
            val mealLineData = it.split(",")
            with(Constant.ColumnIndex) {
                 DataManager.addMeal(
                    Meal(
                        name = mealLineData[NAME],
                        calories = mealLineData[CALORIES].toDouble(),
                        totalFat = mealLineData[TOTAL_FAT].toDouble(),
                        sodium = mealLineData[SODIUM].toDouble(),
                        vitaminC = mealLineData[VITAMIN_C].toDouble(),
                        vitaminD = mealLineData[VITAMIN_D].toDouble(),
                        calcium = mealLineData[CALCIUM].toDouble(),
                        magnesium = mealLineData[MAGNESIUM].toDouble(),
                        potassium = mealLineData[POTASSIUM].toDouble(),
                        protein = mealLineData[PROTEIN].toDouble(),
                        carbohydrate = mealLineData[CARBOHYDRATE].toDouble(),
                        fiber = mealLineData[FIBER].toDouble(),
                        sugars = mealLineData[SUGARS].toDouble(),
                        caffeine = mealLineData[CAFFEINE].toDouble(),
                    )
                )
            }
        }
    }
}