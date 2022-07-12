package com.example.nutritionapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nutritionapp.CSVParser
import com.example.nutritionapp.Calculation
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.util.Constant
import com.example.nutritionapp.util.ReadFiles
import java.io.File
import java.io.InputStreamReader

class HomeActivity : AppCompatActivity() {
    val parser = CSVParser()
    private val calculation: Calculation = Calculation()
    lateinit var mealsList: MutableList<Meal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        openFile()
        mealsList = DataManager.getMeals()
    }

    fun openFile(){
        val inputStream = assets.open(Constant.CSV_FILE_NAME)
        val buffer = InputStreamReader(inputStream)
        parser.getMealsFromCSV(buffer)
    }
}