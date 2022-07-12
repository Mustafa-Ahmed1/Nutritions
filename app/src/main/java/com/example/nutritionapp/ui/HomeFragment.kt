package com.example.nutritionapp.ui

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {}

}