package com.sangtq.home.login

import com.sangtq.database.PreferencesManager
import com.sangtq.feature.home.R
import com.sangtq.feature.home.databinding.ActivityLoginBinding
import com.sangtq.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override val layoutResId: Int = R.layout.activity_login

    override val applyInsetsViewId: Int = R.id.login_root_view

    override val fragmentContainerId: Int = R.id.fragment_container_view

    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun addInitialFragment() {
        super.addInitialFragment()
        if (preferencesManager.getAppBoolean(PreferencesManager.KEY_IS_FIRST_LOGIN, true)) {
            preferencesManager.setAppBoolean(PreferencesManager.KEY_IS_FIRST_LOGIN, false)
            addFragment(FirstLoginFragment())
        } else {
            addFragment(LoginFragment())
        }
    }
}