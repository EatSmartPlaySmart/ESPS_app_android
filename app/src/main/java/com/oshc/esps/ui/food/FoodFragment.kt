package com.oshc.esps.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oshc.esps.R
import com.oshc.esps.databinding.FoodFragmentBinding
import kotlinx.android.synthetic.main.food_fragment.*

class FoodFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel
    lateinit var foodListAdapter: FoodRecyclerViewAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        setupActionBar()

        foodViewModel =
                ViewModelProvider(this).get(FoodViewModel::class.java)

        val binding: FoodFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.food_fragment, container, false)
        binding.viewmodel = foodViewModel
        binding.lifecycleOwner = this

            // livedata observers
            foodViewModel.foodList.observe(viewLifecycleOwner, Observer {
                foodListAdapter = FoodRecyclerViewAdapter(foodViewModel.foodList.value as List<Food>)
                rvFood.layoutManager = LinearLayoutManager(context)
                rvFood.adapter = foodListAdapter
                foodListAdapter.notifyDataSetChanged()
            }
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // query list when user search
//        etFoodSearch.addTextChangedListener { foodViewModel.setFilterText(it.toString()) }
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fragment_title_recipes)
    }

}