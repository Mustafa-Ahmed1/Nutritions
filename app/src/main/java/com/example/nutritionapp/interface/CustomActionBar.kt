package com.example.nutritionapp.`interface`

import androidx.fragment.app.Fragment

interface CustomActionBar {
    var visibilityCustomActionBar:Boolean
    var visibilityBackButton:Boolean
    fun getTitle() : String?
}