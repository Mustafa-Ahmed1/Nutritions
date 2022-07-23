package com.example.nutritionapp.ui.fragment

import com.example.nutritionapp.Calculations
import com.example.nutritionapp.R
import com.example.nutritionapp.data.dataManger.HealthAdviceDataManger
import com.example.nutritionapp.data.model.HealthAdvice
import com.example.nutritionapp.databinding.FragmentHealthAdvicesBinding
import com.example.nutritionapp.ui.base.BaseFragment
import com.example.nutritionapp.util.Constants

class HealthAdvicesFragment : BaseFragment<FragmentHealthAdvicesBinding>() {

    private lateinit var healthAdviceDataManger: HealthAdviceDataManger
    private var healthAdvicesList: MutableList<HealthAdvice> = mutableListOf()
    private val calculations = Calculations()

    override fun bindingInflater(): FragmentHealthAdvicesBinding =
        FragmentHealthAdvicesBinding.inflate(layoutInflater)

    override var visibilityCustomActionBar: Boolean = true
    override var visibilityBackButton: Boolean = false
    override fun getTitle(): String = getString(R.string.health_advices)

    override var visibleBottomNavigationBar: Boolean = true

    override fun setUp() {
        healthAdviceDataManger =
            requireNotNull(arguments?.getParcelable(Constants.KeyValues.HEALTH_ADVICE_DATA_MANAGER))
        healthAdvicesList = (healthAdviceDataManger as HealthAdviceDataManger).getHealthAdvices()
        onButtonNextAdviceClick()
    }

    private fun onButtonNextAdviceClick() {
        binding.changeArrows.setOnClickListener {
            val currentAdvice = calculations.getRandomAdvice(healthAdvicesList)
            binding.headerTitleHealthAdvices.text = currentAdvice.title
            binding.healthAdvicesTextInfo.text = currentAdvice.details
            binding.changeArrows.playAnimation()
        }
    }
}