package com.sangtq.ui

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
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
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        setupFullscreen()

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this

        if (savedInstanceState == null) {
            addInitialFragment()
        }

        initView()
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    @Suppress("DEPRECATION")
    private fun setupFullscreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        WindowCompat.setDecorFitsSystemWindows(window, false)

        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT

        hideSystemUI()
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let { controller ->
                controller.hide(
                    WindowInsets.Type.statusBars() or
                            WindowInsets.Type.navigationBars() or
                            WindowInsets.Type.systemBars()
                )
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                    )
        }
    }

    protected open fun addInitialFragment() {}
    protected open fun initView() {}
    protected open fun initObservers() {}

    protected fun applyWindowInsets(viewId: Int) {
        val view = findViewById<View>(viewId)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
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

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (view is EditText) {
                val outRect = Rect()
                view.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    // Ẩn keyboard
                    view.clearFocus()
                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}