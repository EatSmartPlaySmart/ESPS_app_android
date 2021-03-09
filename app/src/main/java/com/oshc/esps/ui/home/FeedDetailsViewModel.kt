package com.oshc.esps.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedDetailsViewModel : ViewModel() {

    private val _feedDetails = MutableLiveData<Feed>()

    init {
        _feedDetails.value = Feed("")
    }

    val feedDetails: LiveData<Feed>
        get() = _feedDetails

    fun setFeedDetails(feed: Feed){
        _feedDetails.value = feed
    }
}