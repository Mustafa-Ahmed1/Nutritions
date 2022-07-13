package com.example.nutritionapp

import android.util.Log
import com.example.nutritionapp.data.model.Meal

class Calculation {
    fun calculateCustomGramsCalories(caloriesOf100g: Double, mealGrams: Double) = (mealGrams / 100.0) * caloriesOf100g

    fun mealTop5(list:MutableList<Meal>,top:Int):List<Meal>{
//        list.sortByDescending { (it.sugars*-1)+(it.potassium)+(it.carbohydrate*0.7)+(it.fiber*0.5)}

       var l = quicksort (list)
        Log.v("AMEER", "${l[0].name}")
        Log.v("AMEER", "${l[1].name}")
        Log.v("AMEER", "${l[2].name}")
        Log.v("AMEER", "${l[3].name}")
        Log.v("AMEER", "${l[4].name}")
        Log.v("AMEER", "${l[5].name}")


        return list.take(top)
    }

    // Take Left (first) Index of the array and Right (last) Index of the array
    fun quicksort(list:MutableList<Meal>):List<Meal>{
        if (list.size < 2){
            return list
        }
//      finding a pivot using (length of the list)/2 i.e middle element in the list
        val pivot = (list.size/2)
//      filter elements which are equal  the pivot and store it in a list called equal
        val equal = list.filter { ((it.sugars*-1) + (it.potassium) + (it.carbohydrate*0.7) + (it.fiber*0.5)) == ((list[pivot].sugars*-1) + (list[pivot].potassium) + (list[pivot].carbohydrate*0.7) + (list[pivot].fiber*0.5))  }
//      filter elements which are lesser than the pivot and store it in a list called lesser
        val less = list.filter { ((it.sugars*-1) + (it.potassium) + (it.carbohydrate*0.7) + (it.fiber*0.5)) > ((list[pivot].sugars*-1) + (list[pivot].potassium) + (list[pivot].carbohydrate*0.7) + (list[pivot].fiber*0.5)) }
//      filter elements which are greater than the pivot and store it in a list called greater
        val greater = list.filter { ((it.sugars*-1) + (it.potassium) + (it.carbohydrate*0.7) + (it.fiber*0.5)) < ((list[pivot].sugars*-1) + (list[pivot].potassium) + (list[pivot].carbohydrate*0.7) + (list[pivot].fiber*0.5)) }
//      call the function recursively to perform operation, but this time pass the splitted arrays.
//      Do the same process again and again, till we left with multiple arrays with a single element and
//      arranged in order
        return quicksort(less as MutableList<Meal>) + equal + quicksort(greater as MutableList<Meal>)
    }

}



//  var cal = calculation.calculateCustomGramsCalories(mealsList[0].calories, 250.0)


//var rr=Calculation()
//var x=rr.mealTop5(mealsList,5)
//
//Log.v("AMEER", "${x[0].name}")

