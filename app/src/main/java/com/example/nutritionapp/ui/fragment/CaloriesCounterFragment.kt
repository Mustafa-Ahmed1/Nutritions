package com.example.nutritionapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Parcelable
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
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
    override fun getTitle(): String = getString(R.string.total_calories)
    override fun back(): Fragment = HomeFragment()

    @SuppressLint("ResourceType")
    override fun setUp() {

    }

    fun clickEvents() {
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()

        binding.buttonAdd.setOnClickListener {
            binding.labelError.visibility = View.INVISIBLE
            if ((binding.textInputLayout0.editText?.text.toString() != "") && (binding.editTextGrams.text.toString() != "")) {
                var textMealName = Calculations().getListByMealName(
                    binding.textInputLayout0.editText?.text.toString(),
                    mealsList
                )
                var textG = Calculations().calculateCustomGramsCalories(
                    textMealName?.calories.toString().toDouble(),
                    binding.editTextGrams.text.toString().toDouble()
                )
                var totalCalories = (Math.abs(
                    binding.textTotalCaloriesValue.text.toString().toInt() + textG.toInt()
                )).toString()
                if ((binding.textTotalCaloriesValue.text.toString()
                        .toInt() < 15000) && (totalCalories.toDouble() < 15000)
                ) {
                    binding.textTotalCaloriesValue.text = totalCalories
                    clearText()
                    if (binding.textTotalCaloriesValue.text.toString().toInt() > 2572) {
                        binding.apply {
                            textTotalCaloriesValue.setTextColor(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.red
                                )
                            )
                            imageTotalCaloriesRing.setColorFilter(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.red
                                )
                            )
//                            labelError.visibility = View.VISIBLE
//                            labelError.text = resources.getString(R.string.error_label)
                            clearText()
                        }
                        val mToast = Toast.makeText(
                            context,
                            resources.getText(R.string.error_label),
                            Toast.LENGTH_SHORT
                        )
                        mToast.show()
                    }
                } else {
                    binding.apply {
//                        labelError.text = resources.getString(R.string.try_a_less_number_of_grams)
//                        labelError.visibility = View.VISIBLE
                        val mToast = Toast.makeText(
                            context,
                            resources.getText(R.string.try_a_less_number_of_grams),
                            Toast.LENGTH_SHORT
                        )
                        mToast.show()
                        clearText()
                    }
                }

            } else {
//                binding.apply {
//                    labelError.text = resources.getString(R.string.enter_a_valid_meal_name)
//                    labelError.visibility = View.VISIBLE
//                }
                val mToast = Toast.makeText(
                    context,
                    resources.getText(R.string.enter_a_valid_meal_name),
                    Toast.LENGTH_SHORT
                )
                mToast.show()
            }


        }
        binding.buttonReset.setOnClickListener {
            binding.apply {
                clearText()
                textTotalCaloriesValue.text = resources.getString(R.string._0)
                textTotalCaloriesValue.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.primary_color
                    )
                )
                imageTotalCaloriesRing.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.primary_color
                    )
                )
                labelError.visibility = View.INVISIBLE
            }

        }
    }

    fun clearText() {
        binding.apply {
            textInputLayout0.editText?.text?.clear()
            editTextGrams.text.clear()
        }
    }

    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()
        val mealsNamesList: MutableList<String> = mutableListOf()
        makeListOfMealNames(mealsNamesList, mealsList)
        setListAdapter(mealsNamesList)
        clickEvents()
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