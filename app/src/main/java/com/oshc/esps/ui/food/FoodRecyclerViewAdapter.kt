package com.oshc.esps.ui.food

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.oshc.esps.R

class FoodRecyclerViewAdapter(val recipeList: List<Food>):
    RecyclerView.Adapter<FoodRecyclerViewAdapter.FoodRecyclerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodRecyclerViewHolder =
        FoodRecyclerViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.food_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: FoodRecyclerViewHolder, position: Int) {

        val context = holder.itemView.context

        holder.tvTitle.text = recipeList[position].title
        holder.tvDesc.text = recipeList[position].desc

        val img_resource_id = context.resources.getIdentifier(recipeList[position].img,
            "drawable", context.packageName)
        holder.imgFood.setImageResource(img_resource_id)

        // Get badge of filters based on vals passed in filter list and populate linear layout with image view
        holder.llFilters.removeAllViews()
        // todo - change so that views in ll is only added once instead of clearing always
        recipeList[position].filters.forEach { filter ->

            val ivFilterBadge = ImageView(context)
            val id = context.resources.getIdentifier("ic_badge_$filter",
                    "drawable", context.packageName)
            val layoutParams = LinearLayout.LayoutParams(72, 72)
            ivFilterBadge.setLayoutParams(layoutParams)

            // todo - change "cooked_rice" to id of Food
//            ivFilterBadge.background = ResourcesCompat.getDrawable(context.resources, id, null)
            ivFilterBadge.requestLayout()
            holder.llFilters.addView(ivFilterBadge)
        }

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable(context.getString(R.string.key_recipe_parcel), recipeList[position])
            Navigation.findNavController(holder.itemView).navigate(R.id.action_navigation_food_to_foodRecipeFragment, bundle)
        }
    }

    override fun getItemCount() = recipeList.size


    inner class FoodRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle: TextView
        val tvDesc: TextView
        val imgFood: ImageView
        val llFilters: LinearLayout
        init {
            tvTitle = view.findViewById(R.id.tvFoodItemTitle)
            tvDesc = view.findViewById(R.id.tvFoodItemDesc)
            imgFood = view.findViewById(R.id.ivFoodItem)
            llFilters = view.findViewById(R.id.llFilterIcons)
        }
    }
}