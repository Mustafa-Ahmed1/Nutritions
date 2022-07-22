package com.example.nutritionapp.`interface`

import com.example.nutritionapp.data.model.Meal

interface MealInteractionListener {
    fun onClickItem(meal: Meal)
}