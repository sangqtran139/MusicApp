package com.sangtq.ui.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> AppCompatActivity.observe(liveData: LiveData<T>, onChange: (T) -> Unit) {
    liveData.observe(this) { onChange(it) }
}

fun <T> AppCompatActivity.observe(
    liveData: LiveData<T>,
    liveCycleOwner: LifecycleOwner,
    onChange: (T) -> Unit
) {
    liveData.observe(liveCycleOwner) { onChange(it) }
}

fun <T> Fragment.observe(liveData: LiveData<T>, onChange: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { onChange(it) }
}

fun <T> Fragment.observe(
    liveData: LiveData<T>,
    liveCycleOwner: LifecycleOwner,
    onChange: (T) -> Unit
) {
    liveData.observe(liveCycleOwner) { onChange(it) }
}