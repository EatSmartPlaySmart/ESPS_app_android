package com.oshc.esps.ui.policy

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oshc.esps.R
import com.oshc.esps.databinding.PolicyFragmentBinding
import kotlinx.android.synthetic.main.policy_fragment.*


class PolicyFragment : Fragment() {

    companion object {
        fun newInstance() = PolicyFragment()
    }

    private lateinit var viewModel: PolicyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(PolicyViewModel::class.java)
        val binding: PolicyFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.policy_fragment,
            container,
            false
        )
        binding.policy = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()

        // setup preview policy buttons
        btnPolicyActivity.setOnClickListener {
            showDialog("Activity Policy Preview", getPhysicalPolicy(viewModel.companyName.value!!))
        }

        btnPolicyNutrition.setOnClickListener {
            showDialog("Nutrition Policy Preview", getNutritionPolicy(viewModel.companyName.value!!))
        }

        // generate policy with company name and start email intent
        btnPolicyGenerate.setOnClickListener {
            if (etCompanyName.text.isNullOrBlank())
                tilCompanyName.error = "Enter you company name!"
            else if (etEmail.text.isNullOrBlank())
                tilEmail.error = "Enter an email to send to"
            else if ( viewModel.isActivityPolicySelected.value == false && viewModel.isNutritionPolicySelected.value == false)
                Toast.makeText(activity, "Select atleast one policy to generate!", Toast.LENGTH_SHORT).show()
            else {
                val email = viewModel.email.value?.trim()
                composeEmail(arrayOf(email), "ESPS Generated Policies")
            }
        }
    }

    fun showDialog(title: String, message: String) {
        val dialog = android.app.AlertDialog.Builder(activity)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setPositiveButton("OKAY!", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        dialog.create().show()
    }

    /** Starts an email intent from */
    fun composeEmail(addresses: Array<String?>?, subject: String?) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:") // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(
            Intent.EXTRA_TEXT,
                getSelectedPolicyText()
        )
        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null) {
            startActivity(intent)
        }
    }

    /**
     * Returns the appropriate policy depending on what user selected
     */
    private fun getSelectedPolicyText(): String {
        return if (viewModel.isActivityPolicySelected.value == true)
                    getPhysicalPolicy(viewModel.companyName.value!!)
                else
                    getNutritionPolicy(viewModel.companyName.value!!)
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fragment_title_policies)
    }

}

