package com.example.nutritionapp.`interface`

import com.example.nutritionapp.data.model.data.Meal

interface MealInteractionListener {
    fun onClickItem(meal: Meal)
}