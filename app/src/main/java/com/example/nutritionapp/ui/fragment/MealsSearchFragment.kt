package com.example.nutritionapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.`interface`.MealInteractionListener
import com.example.nutritionapp.data.dataManager.MealDataManager
import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.ui.MealAdapter
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class MealsSearchFragment() : BaseFragment<FragmentSearchMealsBinding>(),
    MealInteractionListener {

    private var mealDataManager: Parcelable = MealDataManager()
    private lateinit var mealsList: MutableList<Meal>
    private var mealDetailsFragment = MealDetailsFragment()
    private var calculations = Calculations()
    private lateinit var adapter: MealAdapter

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override var visibilityBackButton: Boolean = false
    override var visibilityCustomActionBar: Boolean = true
    override fun getTitle(): String = getString(R.string.search_for_all_meals)
    override var visibleBottomNavigationBar: Boolean = true

    override fun setUp() {
        onTextChange()
        viewChips()
    }

    override fun onStart() {
        super.onStart()
        mealDataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (mealDataManager as MealDataManager).getMeals()
        adapter = MealAdapter(mealsList, this)
        binding.recyclerMeal.adapter = adapter
    }

    private fun onTextChange(){
        binding.searchEditText.doOnTextChanged { text, _, _, _ ->
            val newMealList = calculations.getMealListByMealSubName(text.toString(), mealsList)
            if (newMealList.isEmpty() && text.toString().isNotEmpty()){
                binding.imageSearch.visibility = View.VISIBLE
                binding.textNoMeal.visibility = View.VISIBLE
            } else {
                binding.imageSearch.visibility = View.GONE
                binding.textNoMeal.visibility = View.GONE
            }
            adapter = MealAdapter(newMealList, this)
            binding.recyclerMeal.adapter = adapter
        }
    }

    override fun onClickItem(meal: Meal) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.KeyValues.MEAL,meal)
        mealDetailsFragment.arguments = bundle
        navigationTo(mealDetailsFragment)
    }
    private fun viewChips() {
        binding.apply {
            caloriesChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) baseViewChip(calculations.sortCalories(mealsList)) else mealList(mealsList)
            }
            totalFatChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) baseViewChip(calculations.sortTotalFat(mealsList)) else mealList(mealsList)
            }
            sugarChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) baseViewChip(calculations.sortSugars(mealsList)) else mealList(mealsList)
            }
            proteinChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) baseViewChip(calculations.sortProtein(mealsList)) else mealList(mealsList)
            }
            vitamindChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) baseViewChip(calculations.sortVitaminD(mealsList)) else mealList(mealsList)
            }
            carbohydrateChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) baseViewChip(calculations.sortCarbohydrate(mealsList)) else mealList(mealsList)
            }
        }
    }
    private fun baseViewChip(mealList:List<Meal>){
        adapter = MealAdapter(mealList, this)
        binding.recyclerMeal.adapter=adapter
    }
    private fun mealList(mealList:List<Meal>){
        mealDataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.Meal_DATA_MANAGER))
        mealsList = (mealDataManager as MealDataManager).getMeals()
        adapter = MealAdapter(mealList, this)
        binding.recyclerMeal.adapter = adapter
    }
}