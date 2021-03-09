package com.oshc.esps.ui.pa

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.oshc.esps.R
import com.oshc.esps.databinding.ActivityDetailsFragmentBinding

class ActivityDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ActivityDetailsFragment()
    }

    private lateinit var viewModel: ActivityDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(ActivityDetailsViewModel::class.java)

        // Get activity object passed in from previous screen
        val activity: Activity? = arguments?.getParcelable(getString(R.string.activity_parcel_key))

        activity?.let {
            viewModel.setActivity(activity)
        }

        val binding: ActivityDetailsFragmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.activity_details_fragment, container, false)

        binding.activity = viewModel.activity.value
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}