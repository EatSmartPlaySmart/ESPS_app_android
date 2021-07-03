package com.oshc.esps.ui.pa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.oshc.esps.R
import com.oshc.esps.databinding.ActivityFragmentBinding
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.android.synthetic.main.food_submit_recipe.*
import kotlin.math.floor


class ActivityFragment : Fragment() {

    companion object {
        fun newInstance() = ActivityFragment()
    }

    private lateinit var viewModel: ActivityViewModel
    lateinit var activityBottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        val binding: ActivityFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.activity_fragment, container, false)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()

        activityBottomSheetBehavior = BottomSheetBehavior.from(activityBottomSheet)

        handleBottomSheet()
    }

    private fun handleBottomSheet() {
        btnActivityBottomSheetClose.setOnClickListener {
            activityBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
        }

        btnActivityBottomSheetSubmit.setOnClickListener {
            //todo change url to activity survey
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uow.au1.qualtrics.com/jfe/form/SV_41wqxDxI9e9g9dI"))
            startActivity(browserIntent)
        }
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fragment_title_activities)
    }


}