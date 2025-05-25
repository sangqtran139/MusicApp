package com.sangtq.home.login

import com.sangtq.feature.home.R
import com.sangtq.feature.home.databinding.FragmentLoginWithPasswordBinding
import com.sangtq.ui.BaseFragmentNoViewModel

class LoginWithPasswordFragment : BaseFragmentNoViewModel<FragmentLoginWithPasswordBinding>() {
    override val layoutResId: Int = R.layout.fragment_login_with_password

    override fun initView() {
        super.initView()
        binding.btnLogin.setOnClickListener { }
        binding.btnGoogle.setOnClickListener { }
        binding.btnFacebook.setOnClickListener { }
        binding.btnApple.setOnClickListener { }
        binding.btnSignUp.setOnClickListener { }
        binding.imgBack.setOnClickListener { (requireActivity() as LoginActivity).onBackPressedDispatcher.onBackPressed() }
    }

}