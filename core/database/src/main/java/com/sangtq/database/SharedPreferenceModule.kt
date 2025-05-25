package com.sangtq.database

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PreferenceAuthQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PreferenceAppQualifier

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {
    @Provides
    @PreferenceAuthQualifier
    @Singleton
    fun provideAuthPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("auth_preferences", Context.MODE_PRIVATE)
    }

    @Provides
    @PreferenceAppQualifier
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    }
}