package com.example.nutritionapp.ui

import android.util.Log
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {
//        binding.buttonTo.setOnClickListener{
//            navigationTo(FragmentDiabeticsScreen())
//        }
        binding.cardDiabetics.setOnClickListener{
            Log.v("sd","is clickable")
        }

    }

}