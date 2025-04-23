package com.sangtq.musicapp

import androidx.fragment.app.viewModels
import com.sangtq.ui.BaseFragment
import com.sangtq.musicapp.databinding.FragmentBBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentB : BaseFragment<FragmentBBinding, BViewMOdel>() {

    override val viewModel: BViewMOdel by viewModels()
    override val layoutResId: Int = R.layout.fragment_b

    override fun setupViewModel() {
        super.setupViewModel()
    }
}

