package com.sangtq.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

abstract class BaseActivity<Binding : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: Binding
        private set

    @get:LayoutRes
    protected abstract val layoutResId: Int

    protected open val applyInsetsViewId: Int? = null

    protected open val fragmentContainerId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this

        applyInsetsViewId?.let { applyWindowInsets(it) }

        if (savedInstanceState == null) {
            addInitialFragment()
        }

        initView()
        initObservers()
    }

    protected open fun addInitialFragment() {}
    protected open fun initView() {}
    protected open fun initObservers() {}

    private fun applyWindowInsets(viewId: Int) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(viewId)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // --- Fragment Actions ---

    fun replaceFragment(
        fragment: Fragment,
        tag: String? = fragment::class.java.simpleName,
        addToBackStack: Boolean = true,
        @IdRes containerId: Int = fragmentContainerId
            ?: error("Container ID not set in BaseActivity")
    ) {
        supportFragmentManager.commit {
            replace(containerId, fragment, tag)
            if (addToBackStack) addToBackStack(tag)
        }
    }

    fun addFragment(
        fragment: Fragment,
        tag: String? = fragment::class.java.simpleName,
        addToBackStack: Boolean = true,
        @IdRes containerId: Int = fragmentContainerId
            ?: error("Container ID not set in BaseActivity")
    ) {
        supportFragmentManager.commit {
            add(containerId, fragment, tag)
            if (addToBackStack) addToBackStack(tag)
        }
    }

    fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    fun clearBackStack() {
        supportFragmentManager.popBackStack(
            null,
            androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }
}


