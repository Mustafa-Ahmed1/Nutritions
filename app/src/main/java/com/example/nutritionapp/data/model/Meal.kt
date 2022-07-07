package com.example.nutritionapp.data.model

data class Meal(
    val name:String,
    val calories: Int,
    val totalFat: Double,
    val saturatedFat: Double?,
    val cholesterol: Int,
    val sodium: Double,
    val vitaminB12: Double,
    val vitaminC: Double,
    val vitaminD: Double,
    val calcium: Int,
    val magnesium: Int,
    val potassium: Int,
    val protein: Double,
    val carbohydrate: Double,
    val fiber: Double,
    val sugars: Double,
    val sucrose: Double,
    val caffeine: Int
)