package com.example.nutritionapp.ui

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constant

class TestFragment : BaseFragment<FragmentTestBinding>() {

    override fun bindingInflater(): FragmentTestBinding =
        FragmentTestBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun title(): String = arguments?.getString(Constant.KeyValues.MEAL_NAME).toString()
    override fun back(): Fragment = MealsSearchFragment()

    override fun setUp() {
        val mealsSearchFragment = MealsSearchFragment()
    }

    override fun onStart() {
        super.onStart()

        arguments?.let {
            with(Constant.KeyValues) {
                val name = it.getString(MEAL_NAME)
                val cal = it.getString(CAL_NUMBER)
                val sugar = it.getString(SUGAR_NUMBER)
                val protein = it.getString(PROTEIN_NUMBER)
                val fiber = it.getString(FIBER_NUMBER)

                with(binding) {
                    caloriesValue.text = cal
                    sugarsValue.text = sugar
                    proteinsValue.text = protein
                    fibersValue.text = fiber
                }
            }
        }
    }



}