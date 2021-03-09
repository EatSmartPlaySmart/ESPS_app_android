package com.oshc.esps.ui.food

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oshc.esps.R
import com.oshc.esps.databinding.FoodRecipeIngredientListItemBinding

class FoodRecipeIngredientsAdapter(var ingredientsList: List<Ingredient>?): RecyclerView.Adapter<FoodRecipeIngredientsAdapter.RecipeIngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeIngredientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : FoodRecipeIngredientListItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.food_recipe_ingredient_list_item, parent, false)
        return RecipeIngredientViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecipeIngredientViewHolder, position: Int) {
        ingredientsList?.get(position)?.let { Log.d("Adapter", it.toString()) }
        holder.bind(ingredientsList?.get(position))
    }

    override fun getItemCount(): Int = ingredientsList?.size ?: 0

    class RecipeIngredientViewHolder(private val binding: FoodRecipeIngredientListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Ingredient?) {
            binding.ingredient = ingredient
            binding.executePendingBindings()
        }
    }
}