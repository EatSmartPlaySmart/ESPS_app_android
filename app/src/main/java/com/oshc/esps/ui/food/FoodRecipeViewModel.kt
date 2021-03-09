package com.oshc.esps.ui.food

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Appendable


class FoodRecipeViewModel(application: Application) : AndroidViewModel(application) {

    private var _foodRecipe = MutableLiveData<Food>()
    lateinit var ingredientListAdapter: FoodRecipeIngredientsAdapter
    val foodRecipe
        get() = _foodRecipe

    fun setFoodRecipe(recipe: Food) {
        _foodRecipe.value = recipe
        ingredientListAdapter = FoodRecipeIngredientsAdapter(_foodRecipe.value?.ingredientsList)
        ingredientListAdapter.notifyDataSetChanged()
    }



}