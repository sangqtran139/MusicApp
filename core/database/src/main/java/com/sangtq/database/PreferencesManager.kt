package com.sangtq.database

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(
    @PreferenceAuthQualifier private val authPreferences: SharedPreferences,
    @PreferenceAppQualifier private val appPreferences: SharedPreferences
) {
    fun setAuthBoolean(key: String, value: Boolean) {
        authPreferences.edit().putBoolean(key, value).apply()
    }

    fun getAuthBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return authPreferences.getBoolean(key, defaultValue)
    }

    fun setAppBoolean(key: String, value: Boolean) {
        appPreferences.edit().putBoolean(key, value).apply()
    }

    fun getAppBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return appPreferences.getBoolean(key, defaultValue)
    }

    companion object {
        // Auth related keys
        const val KEY_IS_LOGGED_IN = "is_logged_in"
        const val KEY_AUTH_TOKEN = "auth_token"

        // App related keys
        const val KEY_IS_FIRST_LOGIN = "is_first_login"
        const val KEY_DARK_MODE = "dark_mode"
    }
}