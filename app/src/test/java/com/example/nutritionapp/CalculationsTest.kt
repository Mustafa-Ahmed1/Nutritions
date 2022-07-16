package com.example.nutritionapp

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

internal class CalculationsTest {

    private lateinit var calculations: Calculations

    @Before
    fun setup() {
        calculations = Calculations()
    }

    // region test functions for calculateCustomGramsCalories function
    @Test
    fun should_ReturnCorrectCaloriesValue_When_EnterCorrectCaloriesAndGrams() {
        // given correct calories and grams
        val caloriesFor100g = 320.0
        val mealGrams = 200.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return correct calories value
        assertEquals(640.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterCorrectCaloriesAndZeroGrams() {
        // given correct calories and zero grams
        val caloriesFor100g = 320.0
        val mealGrams = 0.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterZeroCaloriesAndCorrectGrams() {
        // given zero calories and correct grams
        val caloriesFor100g = 0.0
        val mealGrams = 200.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterZeroCaloriesAndZeroGrams() {
        // given zero calories and zero grams
        val caloriesFor100g = 0.0
        val mealGrams = 0.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterCorrectCaloriesAndNegativeGrams() {
        // given correct calories and negative grams
        val caloriesFor100g = 320.0
        val mealGrams = -200.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterNegativeCaloriesAndCorrectGrams() {
        // given negative calories and correct grams
        val caloriesFor100g = -320.0
        val mealGrams = 200.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterNegativeCaloriesAndNegativeGrams() {
        // given negative calories and negative grams
        val caloriesFor100g = -320.0
        val mealGrams = -200.0
        // when calculate calories for custom grams
        val result = calculations.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }
    // endregion

}