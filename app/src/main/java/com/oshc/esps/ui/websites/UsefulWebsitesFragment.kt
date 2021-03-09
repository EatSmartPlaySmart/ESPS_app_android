package com.oshc.esps.ui.websites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oshc.esps.R
import com.oshc.esps.databinding.UsefulWebsitesFragmentBinding

class UsefulWebsitesFragment : Fragment() {

    companion object {
        fun newInstance() = UsefulWebsitesFragment()
    }

    private lateinit var viewModel: UsefulWebsitesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(UsefulWebsitesViewModel::class.java)
        val binding = DataBindingUtil.inflate<UsefulWebsitesFragmentBinding>(inflater, R.layout.useful_websites_fragment, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupActionBar()
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fragment_title_useful_websites)
    }

}