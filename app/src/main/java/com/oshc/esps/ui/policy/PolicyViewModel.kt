package com.oshc.esps.ui.policy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PolicyViewModel : ViewModel() {

    private var _isNutritionPolicySelected = MutableLiveData<Boolean>()
    private var _isActivityPolicySelected = MutableLiveData<Boolean>()
    var companyName = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var showBenefitsDialog = MutableLiveData<Boolean>()

    init {
        _isNutritionPolicySelected.value = false
        _isActivityPolicySelected.value = false
        companyName.value = "YourCompany"
        email.value = ""
        showBenefitsDialog.value = true
    }

    val isNutritionPolicySelected
        get() = _isNutritionPolicySelected

    val isActivityPolicySelected
        get() = _isActivityPolicySelected

    /*
        Toggle selection of policy buttons
    */
    fun toggleNutrtionPolicySelected() {
        Log.d("Policy", "${_isNutritionPolicySelected.value}")
        _isNutritionPolicySelected.value = !_isNutritionPolicySelected.value!!
        _isActivityPolicySelected.value = false
    }

    fun toggleActivityPolicySelected() {
        _isActivityPolicySelected.value = !_isActivityPolicySelected.value!!
        isNutritionPolicySelected.value = false
    }
}