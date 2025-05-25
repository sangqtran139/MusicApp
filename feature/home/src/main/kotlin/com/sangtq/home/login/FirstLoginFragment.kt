package com.sangtq.home.login

import com.sangtq.feature.home.R
import com.sangtq.feature.home.databinding.FragmentFirstLoginBinding
import com.sangtq.ui.BaseFragmentNoViewModel

class FirstLoginFragment: BaseFragmentNoViewModel<FragmentFirstLoginBinding>() {

    override val layoutResId: Int = R.layout.fragment_first_login

    override fun initView() {
        super.initView()
        binding.btnStart.setOnClickListener {
            (requireActivity() as LoginActivity).replaceFragment(LoginFragment())
        }
    }
}