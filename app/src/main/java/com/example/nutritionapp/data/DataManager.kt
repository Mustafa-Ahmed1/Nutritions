package com.example.nutritionapp.data

import android.os.Parcel
import android.os.Parcelable
import com.example.nutritionapp.data.model.Meal

class DataManager() : Parcelable {

    private val meals: MutableList<Meal> = mutableListOf()

    fun addMeal(meal: Meal) {
        meals.add(meal)
    }

    fun getMeals(): MutableList<Meal> = meals

    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataManager> {
        override fun createFromParcel(parcel: Parcel): DataManager {
            return DataManager(parcel)
        }

        override fun newArray(size: Int): Array<DataManager?> {
            return arrayOfNulls(size)
        }
    }

}