package com.example.nutritionapp.ui

import android.view.LayoutInflater
import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.ActivityMainBinding
import com.example.nutritionapp.ui.base.BaseActivity

class MainActivity: BaseActivity<ActivityMainBinding>() {
    var homeFragment = HomeFragment()

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    override fun setUp() {
        navigate()
    }

    private fun  navigate(){
        binding.button.setOnClickListener{
            val  transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.root_fragment,homeFragment)
            transaction.commit()
        }
    }

}