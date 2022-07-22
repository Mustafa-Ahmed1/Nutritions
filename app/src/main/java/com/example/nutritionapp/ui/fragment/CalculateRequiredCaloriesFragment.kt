package com.example.nutritionapp.ui.fragment

import com.example.nutritionapp.R
import com.example.nutritionapp.databinding.FragmentCalculateRequiredCaloriesBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.istVisible


class CalculateRequiredCaloriesFragment : BaseFragment<FragmentCalculateRequiredCaloriesBinding>()  {

    override fun bindingInflater(): FragmentCalculateRequiredCaloriesBinding =
        FragmentCalculateRequiredCaloriesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = true
    override fun getTitle(): String = getString(R.string.title_calculate_requiredCcalories)

    override var visibleBottomNavigationBar: Boolean = false

    var weight: Int = 0
    var height: Int = 0
    var age: Int = 0
    var resultCalculateRequiredCalories: Int = 0

    override fun setUp() {
        binding.resultCalculateRequiredCalories.text = resultCalculateRequiredCalories.toString()
        binding.textValueWeight.text = weight.toString()
        binding.textValueHeight.text = height.toString()
        binding.textValueAge.text = age.toString()
        binding.resultCalculateRequiredCalories.visibility =  istVisible(false)
        binding.textShow.text = getText(R.string.full_to_get_required_calories)

        plusAge()
        minAge()

        minWeight()
        plusWeight()

        plusHeight()
        minHeight()
    }

    private fun plusAge(){
        binding.plusButtonAge.setOnClickListener{
            age++
            binding.textValueAge.text = age.toString()
        }
    }

    private fun minAge(){
        binding.minButtonAge.setOnClickListener{
            age--
            binding.textValueAge.text = age.toString()
        }
    }

    private fun minWeight(){
        binding.minButtonWeight.setOnClickListener{
            age--
            binding.textValueAge.text = age.toString()
        }
    }

    private fun plusWeight(){
        binding.plusButtonWeight.setOnClickListener{
            age++
            binding.textValueWeight.text = age.toString()
        }
    }

    private fun minHeight(){
        binding.minButtonHeight.setOnClickListener{
            age--
            binding.textValueHeight.text = height.toString()
        }
    }

    private fun plusHeight(){
        binding.plusButtonHeight.setOnClickListener{
            age++
            binding.textValueHeight.text = height.toString()
        }
    }

    
    



}