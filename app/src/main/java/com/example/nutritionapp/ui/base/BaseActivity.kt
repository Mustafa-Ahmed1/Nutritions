package com.example.nutritionapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    abstract fun bindingInflater(): VB
    protected val binding get() = _binding as VB

    abstract fun setUp()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setUp()
        _binding = bindingInflater()
        setContentView(requireNotNull(_binding).root)

    }
}