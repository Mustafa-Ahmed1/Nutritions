package com.example.nutritionapp.`interface`

import androidx.fragment.app.Fragment

interface CustomActionBar {
    var visibilityCustomActionBar:Boolean
    fun getTitle() : String?
    fun back(): Fragment?
}