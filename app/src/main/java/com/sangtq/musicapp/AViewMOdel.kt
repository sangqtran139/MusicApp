package com.sangtq.musicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AViewMOdel @Inject constructor() : ViewModel() {
    private val _someLiveData = MutableLiveData<String>()
    val someLiveData: LiveData<String> get() = _someLiveData

    fun updateData(newData: String) {
        _someLiveData.value = newData
    }
}