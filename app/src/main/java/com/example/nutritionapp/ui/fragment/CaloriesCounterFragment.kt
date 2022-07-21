package com.example.nutritionapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Parcelable
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class CaloriesCounterFragment : BaseFragment<FragmentCounterCaloriesBinding>() {
    private lateinit var dataManager: Parcelable
    private lateinit var mealsList: MutableList<Meal>
    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.total_calories)

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun setUp() {
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()

        binding.buttonAdd.setOnClickListener {
            binding.labelError.visibility = View.INVISIBLE
            if ((binding.textInputLayout0.editText?.text.toString() != "") && (binding.editTextGrams.text.toString() != "")) {
                val textMealName = Calculations().getListByMealName(
                    binding.textInputLayout0.editText?.text.toString(),
                    mealsList
                )
                val textG = Calculations().calculateCustomGramsCalories(
                    textMealName?.calories.toString().toDouble(),
                    binding.editTextGrams.text.toString().toDouble()
                )
                binding.textTotalCaloriesValue.text =
                    (binding.textTotalCaloriesValue.text.toString()
                        .toInt() + textG.toInt()).toString()
                if (binding.textTotalCaloriesValue.text.toString().toInt() > 2572) {
                    binding.textTotalCaloriesValue.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.red
                        )
                    )
                    binding.imageTotalCaloriesRing.setColorFilter(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.red
                        )
                    )
                    binding.labelError.visibility = View.VISIBLE
                    binding.labelError.text = resources.getString(R.string.error_label)
                }
            } else {
                binding.labelError.text = resources.getString(R.string.no_data_to_calculated)
                binding.labelError.visibility = View.VISIBLE
            }
        }
        binding.buttonReset.setOnClickListener {
            binding.textInputLayout0.editText?.text?.clear()
            binding.textTotalCaloriesValue.text = resources.getString(R.string._0)
            binding.editTextGrams.text.clear()
            binding.textTotalCaloriesValue.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.primary_color
                )
            )
            binding.imageTotalCaloriesRing.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.primary_color
                )
            )
            binding.labelError.visibility = View.INVISIBLE
        }
    }


    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()
        val mealsNamesList: MutableList<String> = mutableListOf()
        makeListOfMealNames(mealsNamesList, mealsList)
        setListAdapter(mealsNamesList)
        initViews()
    }

    private fun makeListOfMealNames(mealsNamesList: MutableList<String>, mealsList: List<Meal>) {
        for (element in mealsList) {
            mealsNamesList.add(element.name)
        }
    }

    private fun setListAdapter(list: MutableList<String>) {
        val adapter =
            context?.let { it1 -> ArrayAdapter(it1, R.layout.drop_down_list_item, list) }
        binding.allMeals.setAdapter(adapter)
    }

    private fun initViews() {
        binding.allMeals.setOnItemClickListener { _, _, _, _ ->
            val mealName = binding.allMeals.text.toString()
            val result = Calculations().getListByMealName(mealName, mealsList)

        }
    }


}