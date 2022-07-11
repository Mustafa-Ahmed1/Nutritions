package com.example.nutritionapp.ui

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment

class HomeFragment :BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
    override fun setUp() {
        (activity as MainActivity).findViewById<Button>(R.id.button).visibility = View.GONE
        (activity as MainActivity).findViewById<View>(R.id.widget_app_action).visibility = View.VISIBLE
        (activity as MainActivity).findViewById<TextView>(R.id.app_action_title).text="Home Fragment"

        (activity as MainActivity).findViewById<Button>(R.id.button_back).setOnClickListener{
            (activity as MainActivity).findViewById<Button>(R.id.button).visibility = View.VISIBLE
            (activity as MainActivity).findViewById<View>(R.id.widget_app_action).visibility = View.GONE
            val  transaction = fragmentManager?.beginTransaction()
            transaction?.remove(homeFragment)
            transaction?.commit()
        }
    }

}