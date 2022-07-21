package com.example.nutritionapp.ui.fragment

import android.os.Parcelable
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.model.data.managers.MealDataManager
import com.example.nutritionapp.data.model.data.Meal
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants
import kotlin.math.abs

class CaloriesCounterFragment(): BaseFragment<FragmentCounterCaloriesBinding>() {
    private lateinit var dataManager: Parcelable
    private lateinit var mealsList: MutableList<Meal>
    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.total_calories)

    override var visibleBottomNavigationBar: Boolean = true

    override fun setUp() {}

    private fun clickEvents() {
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (dataManager as MealDataManager).getMeals()
        binding.buttonAdd.setOnClickListener {
            binding.labelError.visibility = View.INVISIBLE
            if ((binding.textInputLayout0.editText?.text.toString() != "") && (binding.editTextGrams.text.toString() != "")) {
                val textMealName = Calculations().getListByMealName(
                    binding.textInputLayout0.editText?.text.toString(),
                    mealsList
                )
                if (textMealName != null) {
                    val textG = Calculations().calculateCustomGramsCalories(
                        textMealName.calories.toString().toDouble(),
                        binding.editTextGrams.text.toString().toDouble()
                    )
                    val totalCalories = (abs(
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
                                clearText()
                            }
                            showToast(R.string.error_label)
                        }
                    } else {
                        binding.apply {
                            showToast(R.string.try_a_less_number_of_grams)
                            clearText()
                        }
                    }
                }
            } else if (binding.editTextGrams.text.isEmpty() && binding.allMeals.text.isEmpty()) {
                showToast(R.string.you_didnt_type_anything_yet)
            } else if (binding.editTextGrams.text.isEmpty()) {
                showToast(R.string.enter_the_number_of_grams)
            } else if (binding.allMeals.text.isEmpty()) {
                showToast(R.string.enter_your_meal_name)
            } else {
                showToast(R.string.enter_a_valid_meal_name)
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

    private fun showToast(nameNotification: Int) {
        val mToast = Toast.makeText(
            context,
            resources.getText(nameNotification),
            Toast.LENGTH_SHORT
        )
        mToast.show()
    }

    fun clearText() {
        binding.apply {
            textInputLayout0.editText?.text?.clear()
            editTextGrams.text.clear()
        }
    }

    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (dataManager as MealDataManager).getMeals()
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