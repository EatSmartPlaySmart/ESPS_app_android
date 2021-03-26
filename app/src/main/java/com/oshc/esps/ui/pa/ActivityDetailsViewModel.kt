package com.oshc.esps.ui.pa

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.square1.richtextlib.ui.web.VideoEnabledWebChromeClient

class ActivityDetailsViewModel : ViewModel() {
    private val _activity = MutableLiveData<Activity>()
    val activity
        get() = _activity

    fun setActivity(activity: Activity){
        _activity.value = activity
    }

    /**
     * Return the equipment list as a string seperated by ','
     */
    fun getEquipmentsAsString(equipmentList: List<String>?): String? {
        return equipmentList?.joinToString { it }
    }

    /**
     * Hide if outdoor activity or the activity is same for indoor or outdoor in which case hide all titles
     */
    fun isIndoorVisible(): Int {
        activity.value?.let {
            return if (it.type == ACTIVITY_TYPE.OUTDOOR)
                View.GONE
            else
                View.VISIBLE

        }
        return View.GONE
    }

    fun isOutdoorVisible(): Int {
        activity.value?.let {
            if ( (it.type == ACTIVITY_TYPE.INDOOR) ||
                (it.type == ACTIVITY_TYPE.INDOOR_OUTDOOR  && it.activities.size == 1))
                return View.GONE
            else
                return View.VISIBLE

        }
        return View.GONE
    }
}