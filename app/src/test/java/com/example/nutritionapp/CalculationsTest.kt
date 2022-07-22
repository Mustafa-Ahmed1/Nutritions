package com.example.nutritionapp

import com.example.nutritionapp.data.model.Meal
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

    // region test functions for diabeticsBestMeals function
    @Test
    fun should_ReturnNullValue_When_EnterListMealNull() {
        // given top and isnull list
        val top =5
        val newMeal= mutableListOf<Meal>()
        // when calculate diabetics
        val result = Calculations().diabeticsBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopValueNegative() {
        // given  top value negative and list meal
        val top =-1
        val newMeal= newList()
        // when calculate diabetics
        val result = Calculations().diabeticsBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopBiggerListSize() {
        // given  top bigger listSize and list
        val top =6
        val newMeal= newList()
        // when calculate diabetics
        val result = Calculations().diabeticsBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }

    @Test
    fun should_ReturnNullValue_When_EnterZeroAndList() {
        // given  top Zero
        val top =0
        val newMeal= newList()
        // when calculate diabetics
        val result = Calculations().diabeticsBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnCorrectValue_When_EnterCorrectTopAndListMeal() {
        // given correct top and list
        val top =5
        val newMeal= newList()
        // when calculate diabetics
        val result = Calculations().diabeticsBestMeals(newMeal,top)
        // then should return correct diabetics value meal list
       assertEquals(newMeal, result)
    }
    // endregion

    // region test functions for bodyBuildingBestMeals function
    @Test
    fun should_ReturnNullValue_When_EnterListMealNullOfBodyBuilding() {
        // given top and isnull list
        val top =5
        val newMeal= mutableListOf<Meal>()
        // when calculate bodyBuildingBestMeals
        val result = Calculations().bodyBuildingBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopValueNegativeOfBodyBuilding() {
        // given  top value negative and list meal
        val top =-1
        val newMeal= newList()
        // when calculate bodyBuildingBestMeals
        val result = Calculations().bodyBuildingBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopBiggerListSizeOfBodyBuilding() {
        // given  top bigger listSize and list
        val top =6
        val newMeal= newList()
        // when calculate bodyBuildingBestMeals
        val result = Calculations().bodyBuildingBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }

    @Test
    fun should_ReturnNullValue_When_EnterZeroTopAndListOfBodyBuilding() {
        // given  top Zero
        val top =0
        val newMeal= newList()
        // when calculate bodyBuildingBestMeals
        val result = Calculations().bodyBuildingBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnCorrectValue_When_EnterCorrectTopAndListMealOfBodyBuilding() {
        // given correct top and list
        val top =5
        val newMeal= newList()
        // when calculate bodyBuildingBestMeals
        val result = Calculations().bodyBuildingBestMeals(newMeal,top)
        // then should return correct bodyBuilding value meal list
        assertEquals(newMeal, result)
    }
// endregion

    // region test functions for weightLossBestMeals function
    @Test
    fun should_ReturnNullValue_When_EnterListMealNullOfCutting() {
        // given top and isnull list
        val top =5
        val newMeal= mutableListOf<Meal>()
        // when calculate weightLossBestMeals
        val result = Calculations().weightLossBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopValueNegativeOfCutting() {
        // given  top value negative and list meal
        val top =-1
        val newMeal= newList()
        // when calculate weightLossBestMeals
        val result = Calculations().weightLossBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopBiggerListSizeOfCutting() {
        // given  top bigger listSize and list
        val top =6
        val newMeal= newList()
        // when calculate weightLossBestMeals
        val result = Calculations().weightLossBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }

    @Test
    fun should_ReturnNullValue_When_EnterZeroTopBiggerListSizeOfCutting() {
        // given  top Zero
        val top =0
        val newMeal= newList()
        // when calculate weightLossBestMeals
        val result = Calculations().weightLossBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnCorrectValue_When_EnterCorrectTopAndListMealOfCutting() {
        // given correct top and list
        val top =5
        val newMeal= newList()
        // when calculate weightLossBestMeals
        val result = Calculations().weightLossBestMeals(newMeal,top)
        // then should return correct cutting value meal list
        assertEquals(newMeal, result)
    }
    // endregion

    // region test functions for bloodPressureBestMeals function
    @Test
    fun should_ReturnNullValue_When_EnterListMealNullOfBloodPressure() {
        // given top and isnull list
        val top =5
        val newMeal= mutableListOf<Meal>()
        // when calculate bloodPressureBestMeals
        val result = Calculations().bloodPressureBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopValueNegativeOfBloodPressure() {
        // given  top value negative and list meal
        val top =-1
        val newMeal= newList()
        // when calculate bloodPressureBestMeals
        val result = Calculations().bloodPressureBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterTopBiggerListSizeOfBloodPressure() {
        // given  top bigger listSize and list
        val top =6
        val newMeal= newList()
        // when calculate bloodPressureBestMeals
        val result = Calculations().bloodPressureBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }

    @Test
    fun should_ReturnNullValue_When_EnterZeroTopAndListOfBloodPressure() {
        // given  top Zero
        val top =0
        val newMeal= newList()
        // when calculate bloodPressureBestMeals
        val result = Calculations().bloodPressureBestMeals(newMeal,top)
        // then should return null value
        assertEquals(null, result)
    }
    @Test
    fun should_ReturnCorrectValue_When_EnterCorrectTopAndListMealOfBloodPressure() {
        // given correct top and list
        val top =5
        val newMeal= newList()
        // when calculate bloodPressureBestMeals
        val result = Calculations().bloodPressureBestMeals(newMeal,top)
        // then should return correct bloodPressure value meal list
        assertEquals(newMeal, result)
    }
    // endregion

    // region test functions for calculatePersonDataCalories male function
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndWeightAndHeightAndNegativeAge() {
        // given correct Gender And Weight And Height And NegativeAge
        val gender = 'M'
        val weight=5.0
        val height=6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndWeightAndNegativeHeightAndAge() {
        // given correct Gender And Weight And NegativeHeight And Age
        val gender = 'M'
        val weight=5.0
        val height=-6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndNegativeWeightAndHeightAndAge() {
        // given correct Gender And NegativeWeight And Height And Age
        val gender = 'M'
        val weight=-5.0
        val height=6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndNegativeWeightAndNegativeHeightAndAge() {
        // given correct Gender And NegativeWeight And NegativeHeight And Age
        val gender = 'M'
        val weight=-5.0
        val height=-6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndWeightAndNegativeHeightAndNegativeAge() {
        // given correct Gender And Weight And NegativeHeight And NegativeAge
        val gender = 'M'
        val weight=5.0
        val height=-6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndNegativeWeightAndHeightAndNegativeAge() {
        // given correct Gender And NegativeWeight And Height And NegativeAge
        val gender = 'M'
        val weight=-5.0
        val height=6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndNegativeWeightAndNegativeHeightAndNegativeAge() {
        // given correct Gender And NegativeWeight And NegativeHeight And NegativeAge
        val gender = 'M'
        val weight=-5.0
        val height=-6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndZeroWeightAndZeroHeightAndAge() {
        // given correct Gender And ZeroWeight And ZeroHeight And Age
        val gender = 'M'
        val weight=0.0
        val height=0.0
        val age =5
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndWeightAndZeroHeightAndZeroAge() {
        // given correct Gender And Weight And ZeroHeight And ZeroAge
        val gender = 'M'
        val weight=5.8
        val height=0.0
        val age =0
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndZeroWeightAndHeightAndZeroAge() {
        // given correct Gender And ZeroWeight And Height And ZeroAge
        val gender = 'M'
        val weight=0.0
        val height=8.9
        val age =0
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleAndZeroWeightAndZeroHeightAndZeroAge() {
        // given correct Gender And ZeroWeight And ZeroHeight And ZeroAge
        val gender = 'M'
        val weight=0.0
        val height=0.0
        val age =0
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderMaleHAndWeightAndHeightAndAge() {
        // given correct Gender H And Weight And Height And Age
        val gender = 'H'
        val weight=5.0
        val height=6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnCorrectValue_When_EnterCorrectGenderMaleAndWeightAndHeightAndAge() {
        // given correct Gender  And Weight And Height And Age
        val gender = 'M'
        val weight=74.0
        val height=171.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(1764.8, result)
    }
    // endregion

    // region test functions for calculatePersonDataCalories Female function
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndWeightAndHeightAndNegativeAge() {
        // given correct Gender And Weight And Height And NegativeAge
        val gender = 'M'
        val weight=5.0
        val height=6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndWeightAndNegativeHeightAndAge() {
        // given correct Gender And Weight And NegativeHeight And Age
        val gender = 'M'
        val weight=5.0
        val height=-6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndNegativeWeightAndHeightAndAge() {
        // given correct Gender And NegativeWeight And Height And Age
        val gender = 'M'
        val weight=-5.0
        val height=6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndNegativeWeightAndNegativeHeightAndAge() {
        // given correct Gender And NegativeWeight And NegativeHeight And Age
        val gender = 'M'
        val weight=-5.0
        val height=-6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndWeightAndNegativeHeightAndNegativeAge() {
        // given correct Gender And Weight And NegativeHeight And NegativeAge
        val gender = 'M'
        val weight=5.0
        val height=-6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndNegativeWeightAndHeightAndNegativeAge() {
        // given correct Gender And NegativeWeight And Height And NegativeAge
        val gender = 'M'
        val weight=-5.0
        val height=6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndNegativeWeightAndNegativeHeightAndNegativeAge() {
        // given correct Gender And NegativeWeight And NegativeHeight And NegativeAge
        val gender = 'M'
        val weight=-5.0
        val height=-6.0
        val age =-25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndZeroWeightAndZeroHeightAndAge() {
        // given correct Gender And ZeroWeight And ZeroHeight And Age
        val gender = 'M'
        val weight=0.0
        val height=0.0
        val age =5
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndWeightAndZeroHeightAndZeroAge() {
        // given correct Gender And Weight And ZeroHeight And ZeroAge
        val gender = 'M'
        val weight=5.8
        val height=0.0
        val age =0
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndZeroWeightAndHeightAndZeroAge() {
        // given correct Gender And ZeroWeight And Height And ZeroAge
        val gender = 'M'
        val weight=0.0
        val height=8.9
        val age =0
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAndZeroWeightAndZeroHeightAndZeroAge() {
        // given correct Gender And ZeroWeight And ZeroHeight And ZeroAge
        val gender = 'M'
        val weight=0.0
        val height=0.0
        val age =0
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnNullValue_When_EnterCorrectGenderFemaleAAndWeightAndHeightAndAge() {
        // given correct Gender H And Weight And Height And Age
        val gender = 'A'
        val weight=5.0
        val height=6.0
        val age =25
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(0.0, result)
    }
    @Test
    fun should_ReturnCorrectValue_When_EnterCorrectGenderFemaleAndWeightAndHeightAndAge() {
        // given correct Gender H And Weight And Height And Age
        val gender = 'F'
        val weight=95.0
        val height=170.0
        val age =28
        // when calculate calculatePersonDataCalories
        val result = Calculations().calculatePersonDataCalories(gender,weight,height,age)
        // then should return null
        assertEquals(1751.4, result)
    }
    // endregion
}







private fun newList():MutableList<Meal>{
var newList= mutableListOf<Meal>().apply {
    add(
        Meal("Cornstarch",381.01,5.1,9.01,0.0 ,0.00 ,5.9,6.2,2.5,9.5,82.9,0.2,9.7,1.0)
    )
    add(
        Meal("Nuts - pecans",381.08,2.1,9.20,0.1 ,0.5 ,5.0,6.12,0.5,98.5,85.9,0.2,9.7,1.0)
    )
    add(
        Meal("Eggplant - raw",381.03,9.1,9.30,0.2 ,0.1 ,5.5,6.22,9.5,92.5,8.89,0.2,9.7,1.0)
    )
    add(
        Meal("Teff - uncooked",381.07,8.1,9.04,0.3,0.3 ,5.1,6.32,3.5,93.5,8.39,0.2,9.7,1.0)
    )
    add(
        Meal("Sherbet - orange",381.04,4.1,5.00,0.4 ,0.7 ,5.3,6.42,9.5,91.5,18.9,0.2,9.7,1.0)
    )
}
    return newList
}