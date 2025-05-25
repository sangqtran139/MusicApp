package com.sangtq.musicapp

import android.annotation.SuppressLint
import android.content.Intent
import com.sangtq.feature.home.R
import com.sangtq.feature.home.databinding.ActivitySplashBinding
import com.sangtq.home.login.LoginActivity
import com.sangtq.ui.BaseActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val layoutResId: Int = R.layout.activity_splash

    override val applyInsetsViewId: Int = R.id.view_container

    override fun initView() {
        super.initView()
        android.os.Handler(mainLooper)
            .postDelayed(
                { startActivity(Intent(this, LoginActivity::class.java)) },
                TIME_SWITCH_ACTIVITY
            )
    }

    companion object {
        private const val TIME_SWITCH_ACTIVITY = 2000L
    }
}