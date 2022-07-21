package com.example.nutritionapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Parcelable
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.`interface`.MealWithGramsInteractionListener
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.MealWithGrams
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.databinding.FragmentCounterCaloriesBinding
import com.example.nutritionapp.ui.CaloriesCounterAdapter
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

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
    override fun getTitle(): String = getString(R.string.total_calories)
    override fun back(): Fragment = HomeFragment()

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun setUp() {
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()

        with (binding) {
        buttonAdd.setOnClickListener {
            mealID++
            labelError.visibility = View.INVISIBLE
            if ((textInputLayout0.editText?.text.toString() != "") && (editTextGrams.text.toString() != "")) {
                val currentMeal = calculations.getListByMealName(
                    textInputLayout0.editText?.text.toString(),
                    mealsList
                )
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
                mealWithGramsList.add(
                    MealWithGrams(
                        mealID, textInputLayout0.editText?.text.toString(),
                        editTextGramsLayout.editText?.text.toString().toInt()
                    )
                )
                adapter = CaloriesCounterAdapter(mealWithGramsList, this@CaloriesCounterFragment)
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


    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()
        val mealsNamesList: MutableList<String> = mutableListOf()
        makeListOfMealNames(mealsNamesList, mealsList)
        setListAdapter(mealsNamesList)
        adapter = CaloriesCounterAdapter(mealWithGramsList, this)
        binding.recyclerViewMealWithGrams.adapter = adapter
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
//            val result = calculations.getListByMealName(mealName, mealsList)
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