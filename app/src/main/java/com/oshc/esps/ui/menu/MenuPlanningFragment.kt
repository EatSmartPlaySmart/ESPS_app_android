package com.oshc.esps.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oshc.esps.R
import com.oshc.esps.databinding.MenuPlanningFragmentBinding
import kotlinx.android.synthetic.main.menu_planning_fragment.*

class MenuPlanningFragment : Fragment() {

    companion object {
        fun newInstance() = MenuPlanningFragment()
    }

    private lateinit var viewModel: MenuPlanningViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MenuPlanningViewModel::class.java)
        val binding: MenuPlanningFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.menu_planning_fragment, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupActionBar()
        viewModel.nevefoodData.observe(viewLifecycleOwner, Observer {
            lvMenuPlanningNeverFood.adapter = activity?.let { it1 -> ArrayAdapter<String>(it1, android.R.layout.simple_list_item_1, it) }
            (lvMenuPlanningNeverFood.adapter as ArrayAdapter<*>).notifyDataSetChanged()
            setListViewHeightBasedOnChildren(lvMenuPlanningNeverFood)

        })

    }

    /** Set height of listview to grow depending on items */
    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter: ListAdapter = listView.adapter ?: return
        var totalHeight = 0
        for (i in 0 until listAdapter.count) {
            val listItem: View = listAdapter.getView(i, null, listView)
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }
        val params: ViewGroup.LayoutParams = listView.getLayoutParams()
        params.height = totalHeight + listView.getDividerHeight() * (listAdapter.getCount() - 1)
        listView.layoutParams = params
        listView.requestLayout()
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fragment_title_menu_planning)
    }

}