package com.example.nutritionapp.ui.fragment

import androidx.fragment.app.Fragment
import com.example.nutritionapp.databinding.FragmentTestBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class MealDetailsFragment : BaseFragment<FragmentTestBinding>() {

    override fun bindingInflater(): FragmentTestBinding =
        FragmentTestBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = arguments?.getString(Constants.KeyValues.MEAL_NAME).toString()
    override fun back(): Fragment = MealsSearchFragment()

    override fun setUp() {

    }

    override fun onStart() {
        super.onStart()

        arguments?.let {
            with(Constants.KeyValues) {
                val cal = it.getString(CAL_NUMBER)
                val sugar = it.getString(SUGAR_NUMBER)
                val protein = it.getString(PROTEIN_NUMBER)
                val fiber = it.getString(FIBER_NUMBER)

                binding.apply {
                    caloriesValue.text = cal
                    sugarsValue.text = sugar
                    proteinsValue.text = protein
                    fibersValue.text = fiber
                }
            }
        }
    }
}