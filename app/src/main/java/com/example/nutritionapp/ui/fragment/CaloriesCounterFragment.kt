package com.example.nutritionapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.`interface`.MealWithGramsInteractionListener
import com.example.nutritionapp.data.MealWithGrams
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.data.model.managers.MealDataManager
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.CaloriesCounterAdapter
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants
import kotlin.math.abs

class CaloriesCounterFragment : BaseFragment<FragmentCounterCaloriesBinding>(),
    MealWithGramsInteractionListener {
    private lateinit var dataManager: Parcelable
    private var mealID = 0
    private val calculations = Calculations()
    private lateinit var mealsList: MutableList<Meal>
    private lateinit var adapter: CaloriesCounterAdapter
    private var mealWithGramsList = mutableListOf<MealWithGrams>()
    override fun bindingInflater(): FragmentCounterCaloriesBinding =
        FragmentCounterCaloriesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.calories_counter)

    override var visibleBottomNavigationBar: Boolean = true

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun setUp() {
        with(binding) {
            buttonAdd.setOnClickListener {
                labelError.visibility = View.INVISIBLE
                if ((textInputLayout0.editText?.text.toString() != "") && (editTextGrams.text.toString() != "")) {
                    val currentMeal = calculations.getListByMealName(
                        textInputLayout0.editText?.text.toString(),
                        mealsList
                    )
                    Log.v("ASDD", textInputLayout0.editText?.text.toString())
                    val mealCustomGramsCalories = calculations.calculateCustomGramsCalories(
                        currentMeal?.calories.toString().toDouble(),
                        editTextGrams.text.toString().toDouble()
                    )
                    textTotalCaloriesValue.text =
                        (textTotalCaloriesValue.text.toString()
                            .toInt() + mealCustomGramsCalories.toInt()).toString()
                    if (textTotalCaloriesValue.text.toString().toInt() > 2572) {
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
                        labelError.visibility = View.VISIBLE
                        labelError.text = resources.getString(R.string.error_label)
                    }
                    Log.v("HJK", mealWithGramsList.toString())

                    Log.v("HJK", mealWithGramsList.toString())
                    adapter =
                        CaloriesCounterAdapter(mealWithGramsList, this@CaloriesCounterFragment)
                    recyclerViewMealWithGrams.adapter = adapter
                    textInputLayout0.editText?.text?.clear()
                    editTextGrams.text?.clear()
                } else {
                    labelError.text = resources.getString(R.string.no_data_to_calculated)
                    labelError.visibility = View.VISIBLE
                }
            }
            buttonReset.setOnClickListener {
                textInputLayout0.editText?.text?.clear()
                textTotalCaloriesValue.text = resources.getString(R.string._0)
                editTextGrams.text?.clear()
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
                mealWithGramsList = mutableListOf()
                adapter = CaloriesCounterAdapter(mealWithGramsList, this@CaloriesCounterFragment)
                recyclerViewMealWithGrams.adapter = adapter
            }
        }
    }

    private fun clickEvents() {
        dataManager =
            requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (dataManager as MealDataManager).getMeals()
        with(binding)
        {
            buttonAdd.setOnClickListener {
                labelError.visibility = View.INVISIBLE
                if ((textInputLayout0.editText?.text.toString() != "") && (editTextGrams.text.toString() != "")) {
                    val currentMeal = Calculations().getListByMealName(
                        textInputLayout0.editText?.text.toString(),
                        mealsList
                    )
                    if (currentMeal != null) {
                        val textG = Calculations().calculateCustomGramsCalories(
                            currentMeal.calories.toString().toDouble(),
                            editTextGrams.text.toString().toDouble()
                        )
                        val totalCalories = (abs(
                            textTotalCaloriesValue.text.toString().toInt() + textG.toInt()
                        )).toString()
                        if ((textTotalCaloriesValue.text.toString()
                                .toInt() < 15000) && (totalCalories.toDouble() < 15000)) {
                            mealID++
                            textTotalCaloriesValue.text = totalCalories
                            if (textTotalCaloriesValue.text.toString().toInt() > 2572) {
                                apply {
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
                                }
                                showToast(R.string.error_label)
                            }
                            mealWithGramsList.add(
                                MealWithGrams(
                                    mealID, textInputLayout0.editText?.text.toString(),
                                    editTextGrams.text.toString().toInt()
                                )
                            )
                            adapter =
                                CaloriesCounterAdapter(mealWithGramsList, this@CaloriesCounterFragment)
                            recyclerViewMealWithGrams.adapter = adapter
                            clearText()
                        } else {
                            apply {
                                showToast(R.string.try_a_less_number_of_grams)
                                clearText()
                            }
                        }
                    } else {
                        showToast(R.string.enter_a_valid_meal_name)
                        clearText()
                    }
                } else if (editTextGrams.text.isEmpty() && allMeals.text.isEmpty()) {
                    showToast(R.string.you_didnt_type_anything_yet)
                } else if (editTextGrams.text.isEmpty()) {
                    showToast(R.string.enter_the_number_of_grams)
                } else if (allMeals.text.isEmpty()) {
                    showToast(R.string.enter_your_meal_name)
                } else {
                    showToast(R.string.enter_a_valid_meal_name)
                }
            }

            buttonReset.setOnClickListener {
                apply {
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
                    mealWithGramsList = mutableListOf()
                    adapter =
                        CaloriesCounterAdapter(mealWithGramsList, this@CaloriesCounterFragment)
                    recyclerViewMealWithGrams.adapter = adapter
                }
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
        apply {
            binding.textInputLayout0.editText?.text?.clear()
            binding.editTextGrams.text.clear()
        }
    }

    override fun onStart() {
        super.onStart()
        dataManager =
            requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (dataManager as MealDataManager).getMeals()
        val mealsNamesList: MutableList<String> = mutableListOf()
        makeListOfMealNames(mealsNamesList, mealsList)
        setListAdapter(mealsNamesList)
        adapter = CaloriesCounterAdapter(mealWithGramsList, this)
        binding.recyclerViewMealWithGrams.adapter = adapter
        clickEvents()
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

//    private fun initViews() {
//        binding.allMeals.setOnItemClickListener { _, _, _, _ ->
//            val mealName = binding.allMeals.text.toString()
//
//            val result = Calculations().getListByMealName(mealName, mealsList)
//
//
//        }
//    }

    override fun onClickClose(meal: MealWithGrams) {
        val currentMeal = calculations.getListByMealName(
            meal.mealName,
            mealsList
        )
        val mealCustomGramsCalories = calculations.calculateCustomGramsCalories(
            currentMeal?.calories.toString().toDouble(),
            meal.mealGrams.toDouble()
        )
        binding.textTotalCaloriesValue.text =
            (binding.textTotalCaloriesValue.text.toString()
                .toInt() - mealCustomGramsCalories.toInt()).toString()
        if (binding.textTotalCaloriesValue.text.toString().toInt() < 2572) {
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
            binding.labelError.visibility = View.GONE
            binding.labelError.text = resources.getString(R.string.error_label)
        }
        mealWithGramsList = mealWithGramsList.filter {
            it.mealName != meal.mealName || it.mealGrams != meal.mealGrams || it.mealID != meal.mealID
        }.toMutableList()
        adapter = CaloriesCounterAdapter(mealWithGramsList, this)
        binding.recyclerViewMealWithGrams.adapter = adapter
    }
}