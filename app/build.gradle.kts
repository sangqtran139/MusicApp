plugins {
    alias(libs.plugins.music.android.application)
}

android {
    namespace = "com.sangtq.musicapp"

    defaultConfig {
        applicationId = "com.sangtq.music"
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
    implementation(libs.ssp.android)
    implementation(libs.sdp.android)
    implementation(project(":feature:home"))
}