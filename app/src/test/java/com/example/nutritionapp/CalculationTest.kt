package com.example.nutritionapp

import org.junit.Test
import org.junit.Before
import kotlin.test.assertEquals

internal class CalculationTest {

    private  lateinit var calculation: Calculation

    @Before
    fun setup() {
        calculation = Calculation()
    }

    // region test functions for calculateCustomGramsCalories function
    @Test
    fun should_ReturnCorrectCaloriesValue_When_EnterCorrectCaloriesAndGrams() {
        // given correct calories and grams
        val caloriesFor100g = 320.0
        val mealGrams = 200.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return correct calories value
        assertEquals(640.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterCorrectCaloriesAndZeroGrams() {
        // given correct calories and zero grams
        val caloriesFor100g = 320.0
        val mealGrams = 0.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterZeroCaloriesAndCorrectGrams() {
        // given zero calories and correct grams
        val caloriesFor100g = 0.0
        val mealGrams = 200.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterZeroCaloriesAndZeroGrams() {
        // given zero calories and zero grams
        val caloriesFor100g = 0.0
        val mealGrams = 0.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterCorrectCaloriesAndNegativeGrams() {
        // given correct calories and negative grams
        val caloriesFor100g = 320.0
        val mealGrams = -200.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterNegativeCaloriesAndCorrectGrams() {
        // given negative calories and correct grams
        val caloriesFor100g = -320.0
        val mealGrams = 200.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnZeroValue_When_EnterNegativeCaloriesAndNegativeGrams() {
        // given negative calories and negative grams
        val caloriesFor100g = -320.0
        val mealGrams = -200.0
        // when calculate calories for custom grams
        val result = calculation.calculateCustomGramsCalories(caloriesFor100g, mealGrams)
        // then should return zero value
        assertEquals(0.0, result)
    }
    // endregion
}