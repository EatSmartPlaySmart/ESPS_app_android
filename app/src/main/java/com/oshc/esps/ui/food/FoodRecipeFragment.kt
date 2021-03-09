package com.oshc.esps.ui.food

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.oshc.esps.R
import com.oshc.esps.databinding.FoodRecipeFragmentBinding
import kotlinx.android.synthetic.main.food_recipe_fragment.*

class FoodRecipeFragment : Fragment() {

    companion object {
        fun newInstance() = FoodRecipeFragment()
    }

    private lateinit var viewModel: FoodRecipeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(FoodRecipeViewModel::class.java)
        val binding: FoodRecipeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.food_recipe_fragment, container, false)
        binding.viewmodel = viewModel

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
        toolbarFoodRecipe.setNavigationIcon(R.drawable.ic_back);
        toolbarFoodRecipe.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        // get recipe passed in from food menu page
        arguments?.getParcelable<Food>(getString(R.string.key_recipe_parcel))?.let {
            viewModel.setFoodRecipe(it)
        }

        val resource = context?.resources?.getIdentifier(viewModel.foodRecipe.value?.img,
            "drawable", context?.packageName)
        resource?.let { ivFoodRecipe.setImageResource(it) }
    }

}