package com.sangtq.home.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sangtq.feature.home.R
import com.sangtq.feature.home.databinding.ActivitySplashBinding

class SplashActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val splashPagerAdapter by lazy {
        SplashPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        binding.fragmentViewPager.adapter = splashPagerAdapter
        binding.fragmentViewPager.isUserInputEnabled = true
    }
}