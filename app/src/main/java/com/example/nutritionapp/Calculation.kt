package com.example.nutritionapp

import com.example.nutritionapp.data.model.Meal

class Calculation {
    fun calculateCustomGramsCalories(caloriesOf100g: Double, mealGrams: Double) = (mealGrams / 100.0) * caloriesOf100g

    fun mealTop5(list:MutableList<Meal>,top:Int):List<Meal>{
        list.sortByDescending { (it.sugars*-1)+(it.potassium)+(it.carbohydrate*0.7)+(it.fiber*0.5)}
        return list.take(top)
    }

}



//  var cal = calculation.calculateCustomGramsCalories(mealsList[0].calories, 250.0)


//var rr=Calculation()
//var x=rr.mealTop5(mealsList,5)
//
//Log.v("AMEER", "${x[0].name}")

