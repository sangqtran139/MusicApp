plugins {
    alias(libs.plugins.weather.android.application)
}

android {
    namespace = "com.sangtq.weatherapp"

    defaultConfig {
        applicationId = "com.sangtq.weather"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core:ui"))
}