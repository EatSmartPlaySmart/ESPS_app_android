package com.oshc.esps.ui.home

import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.*
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Feed(var title: String): Parcelable

class HomeViewModel : ViewModel() {

    private val _feedList = MutableLiveData<MutableList<Feed>>()

    private var query = MutableLiveData<String>()
    init {
        populateData()
        query.value = ""
//        Log.d("HomeViewModel", _feedList.value.toString())
    }
//    private val _feedList =

    val feedList = Transformations.switchMap(query) { searchString ->
        if (searchString.isBlank()) {
            _feedList
        } else {
            val dataListFiltered = MutableLiveData<MutableList<Feed>>()
            dataListFiltered.value = mutableListOf()
            _feedList.value?.forEach {
                if (it.title.contains(searchString, ignoreCase = true))
                    dataListFiltered.value?.add(it)
            }

            dataListFiltered
        }
    }




    fun setFilterText(filterText: String) {
        query.value = filterText
        Log.d("HomeViewModel", "Filter: ${query.value}")
    }

    private fun populateData() {
        _feedList.value = mutableListOf()
        _feedList.value?.run {
            add(Feed("Food handling and hygeine"))
            add(Feed("Food handling and hygeine"))
            add(Feed("Food handling and hygeine"))
            add(Feed("kids handling and hygeine"))
        }
    }

}