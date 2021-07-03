package com.oshc.esps.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.oshc.esps.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.home_fragment, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.hide()

        handleGridSelection()
    }

    private fun handleGridSelection() {

        cvGridRecipes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_food)
        }

        cvGridPolicies.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_policyFragment)
        }

        cvGridActivities.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_activityFragment)
        }

        cvGridMenu.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_menuPlanning)
        }

        cvGridWebsites.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_usefulWebsitesFragment)
        }

        cvGridInfo.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_generalInfoFragment)
        }
    }

}