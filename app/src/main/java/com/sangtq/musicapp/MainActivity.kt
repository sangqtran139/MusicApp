package com.sangtq.musicapp

import com.sangtq.ui.BaseActivity
import com.sangtq.musicapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_main

    override val applyInsetsViewId: Int
        get() = R.id.main_container

    override val fragmentContainerId: Int
        get() = R.id.fragment_container

    override fun addInitialFragment() {
        addFragment(FragmentA())
    }

    override fun initView() {

    }

    override fun initObservers() {
    }
}