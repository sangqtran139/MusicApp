plugins {
    alias(libs.plugins.music.android.library)
}

android {
    namespace = "com.sangtq.feature.home"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(libs.ssp.android)
    implementation(libs.sdp.android)
}