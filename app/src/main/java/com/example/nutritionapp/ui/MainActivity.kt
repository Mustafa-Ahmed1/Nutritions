package com.example.nutritionapp.ui

import android.view.View
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.ActivityMainBinding
import com.example.nutritionapp.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    override fun setUp() {
        findViewById<View>(R.id.widget_app_action).visibility = View.GONE
        binding.button.visibility = View.VISIBLE
        navigate()
    }

    private fun navigate() {
        binding.button.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.root_fragment, homeFragment)
            transaction.commit()
        }
    }

}