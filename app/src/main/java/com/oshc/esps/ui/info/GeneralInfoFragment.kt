package com.oshc.esps.ui.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.oshc.esps.R
import kotlinx.android.synthetic.main.general_info_fragment.*

class GeneralInfoFragment : Fragment() {

    companion object {
        fun newInstance() = GeneralInfoFragment()
    }

    private lateinit var viewModel: GeneralInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.general_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupActionBar()
        viewModel = ViewModelProvider(this).get(GeneralInfoViewModel::class.java)
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fragment_title_general_info)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvGeneralInfo.text = HtmlCompat.fromHtml(getString(R.string.general_info_text), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}