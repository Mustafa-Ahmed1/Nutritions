package com.example.nutritionapp.ui.fragment

import android.os.Parcelable
import com.example.nutritionapp.R
import com.example.nutritionapp.data.DataManager
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

    private var dataManager: Parcelable = DataManager()

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val diabeticsScreenFragment = FragmentDiabeticsScreen()
    private val mealsSearchFragment = MealsSearchFragment()
    private val caloriesCounterFragment = CaloriesCounterFragment()

    override var visibleBottomNavigationBar: Boolean = true

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.best_meals)

    override fun setUp() {
        buttonCardDiabetics()
//        buttonShowAll()
//        buttonCaloriesCounter()
    }

    override fun onStart() {
        super.onStart()
        dataManager = requireNotNull(arguments?.getParcelable(Constants.KeyValues.DATA_MANAGER))
    }

    private fun buttonCardDiabetics() {
        binding.cardDiabetics.setOnClickListener {
            navigationTo(diabeticsScreenFragment)
        }
    }

//    private fun buttonShowAll() {
//        val bundle = Bundle()
//        binding.showAll.setOnClickListener {
//            bundle.putParcelable(Constants.KeyValues.DATA_MANAGER, dataManager)
//            mealsSearchFragment.arguments = bundle
//            navigationTo(mealsSearchFragment)
//        }
//    }

//    private fun buttonCaloriesCounter() {
//        val bundle = Bundle()
//        binding.caloriesCounter.setOnClickListener {
//            bundle.putParcelable(Constants.KeyValues.DATA_MANAGER, dataManager)
//            caloriesCounterFragment.arguments = bundle
//            navigationTo(caloriesCounterFragment)
//        }
//    }


}