package com.example.nutritionapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.nutritionapp.R

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    abstract fun bindingInflater(): VB
    protected val binding get() = _binding as VB

    abstract fun initFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        initFragment()
        _binding = bindingInflater()
        setContentView(requireNotNull(_binding).root)
    }
}