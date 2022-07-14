package com.example.nutritionapp.ui

import android.os.Bundle
import android.system.Os.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.nutritionapp.Calculation
import com.example.nutritionapp.databinding.FragmentDiabeticsScreenBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constant
import java.io.InputStreamReader

class DiabeticsScreen: BaseFragment<FragmentDiabeticsScreenBinding>() {
    override fun bindingInflater(): FragmentDiabeticsScreenBinding=FragmentDiabeticsScreenBinding.inflate(layoutInflater)

    override fun setUp() {

    }


}