package com.example.nutritionapp.data

import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.data.model.Meal
import java.io.File

object DataManager {
    private val meals: MutableList<Meal> = mutableListOf()

    fun addMeal(meal: Meal) { meals.add(meal)}

    fun getMeals(): MutableList<Meal> = meals
}