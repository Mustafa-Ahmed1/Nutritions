package com.example.nutritionapp

import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.util.Constants
import com.example.nutritionapp.util.extention.toPureNumber
import java.io.InputStreamReader

class CSVParser {
    fun getMealsFromCSV(buffer: InputStreamReader): DataManager {
        val dataManager = DataManager()
        buffer.forEachLine {
            val mealLineData = it.split(",")
            with(Constants.ColumnIndex) {
                 dataManager.addMeal(
                    Meal(
                        name = mealLineData[NAME],
                        calories = mealLineData[CALORIES].toDouble(),
                        totalFat = mealLineData[TOTAL_FAT].toPureNumber(),
                        sodium = mealLineData[SODIUM].toPureNumber(),
                        vitaminC = mealLineData[VITAMIN_C].toPureNumber(),
                        vitaminD = mealLineData[VITAMIN_D].toPureNumber(),
                        calcium = mealLineData[CALCIUM].toPureNumber(),
                        magnesium = mealLineData[MAGNESIUM].toPureNumber(),
                        potassium = mealLineData[POTASSIUM].toPureNumber(),
                        protein = mealLineData[PROTEIN].toPureNumber(),
                        carbohydrate = mealLineData[CARBOHYDRATE].toPureNumber(),
                        fiber = mealLineData[FIBER].toPureNumber(),
                        sugars = mealLineData[SUGARS].toPureNumber(),
                        caffeine = mealLineData[CAFFEINE].toPureNumber(),
                    )
                )
            }
        }
        return dataManager
    }
}