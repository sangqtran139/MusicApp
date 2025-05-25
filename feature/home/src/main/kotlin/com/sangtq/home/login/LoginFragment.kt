package com.sangtq.home.login

import com.sangtq.feature.home.R
import com.sangtq.feature.home.databinding.FragmentLoginBinding
import com.sangtq.ui.BaseFragmentNoViewModel

class LoginFragment : BaseFragmentNoViewModel<FragmentLoginBinding>() {
    override val layoutResId: Int = R.layout.fragment_login

    override fun initView() {
        super.initView()
        binding.btnLogin.setOnClickListener {
            (requireActivity() as LoginActivity).addFragment(
                LoginWithPasswordFragment()
            )
        }
        binding.btnGoogle.setOnClickListener { }
        binding.btnFacebook.setOnClickListener { }
        binding.btnApple.setOnClickListener { }
        binding.btnSignUp.setOnClickListener { }
    }
}