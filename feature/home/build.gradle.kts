plugins {
    alias(libs.plugins.music.android.library)
}

android {
    namespace = "com.sangtq.feature.home"
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.database)
    implementation(libs.ssp.android)
    implementation(libs.sdp.android)
}