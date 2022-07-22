package com.example.nutritionapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.core.widget.doOnTextChanged
import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.data.model.Meal
import com.example.nutritionapp.`interface`.MealInteractionListener
import com.example.nutritionapp.databinding.FragmentSearchMealsBinding
import com.example.nutritionapp.ui.MealAdapter
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class MealsSearchFragment : BaseFragment<FragmentSearchMealsBinding>(), MealInteractionListener {

    private var dataManager: Parcelable = DataManager()
    private lateinit var mealsList: MutableList<Meal>
    private var mealDetailsFragment = MealDetailsFragment()
    private var calculations = Calculations()
    private lateinit var adapter: MealAdapter

    override fun bindingInflater(): FragmentSearchMealsBinding =
        FragmentSearchMealsBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.search_for_all_meals)

    override var visibleBottomNavigationBar: Boolean = true

    override fun setUp() {
        onTextChange()
        viewChips()
    }

    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()
        adapter = MealAdapter(mealsList, this)
        binding.recyclerMeal.adapter = adapter
    }

    private fun onTextChange(){
        binding.searchEditText.doOnTextChanged { text, start, before, count ->
            val newMealList = calculations.getMealListByMealSubName(text.toString(), mealsList)
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
            caloriesChip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) baseViewChip(calculations.sortCalories(mealsList)) else mealList(mealsList)
            }
            totalFatChip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) baseViewChip(calculations.sortTotalFat(mealsList)) else mealList(mealsList)
            }
            fabricChip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) baseViewChip(calculations.sortFiber(mealsList)) else mealList(mealsList)
            }
            sugarChip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) baseViewChip(calculations.sortSugars(mealsList)) else mealList(mealsList)
            }
            proteinChip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) baseViewChip(calculations.sortProtein(mealsList)) else mealList(mealsList)
            }

        }
    }
   private fun baseViewChip(mealList:List<Meal>){
        adapter = MealAdapter(mealList, this)
        binding.recyclerMeal.adapter=adapter
    }
    private fun mealList(mealList:List<Meal>){
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
        mealsList = (dataManager as DataManager).getMeals()
        adapter = MealAdapter(mealList, this)
        binding.recyclerMeal.adapter = adapter
    }
}


