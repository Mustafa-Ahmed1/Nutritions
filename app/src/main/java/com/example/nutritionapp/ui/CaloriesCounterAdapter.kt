package com.example.nutritionapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionapp.R
import com.example.nutritionapp.`interface`.MealWithGramsInteractionListener
import com.example.nutritionapp.data.MealWithGrams
import com.example.nutritionapp.databinding.ItemCaloriesCounterBinding

class CaloriesCounterAdapter(val list: List<MealWithGrams>, private val listener: MealWithGramsInteractionListener) :
    RecyclerView.Adapter<CaloriesCounterAdapter.CaloriesCounterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaloriesCounterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calories_counter, parent, false)
        return CaloriesCounterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CaloriesCounterViewHolder, position: Int) {
        val currentMeal = list[position]
        holder.binding.apply {
            textMealName.text = currentMeal.mealName
            "${currentMeal.mealGrams}g".also { textGrams.text = it }
            iconClose.setOnClickListener { listener.onClickClose(currentMeal) }
        }
    }

    override fun getItemCount(): Int = list.size

    class CaloriesCounterViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemCaloriesCounterBinding.bind(viewItem)
    }
}