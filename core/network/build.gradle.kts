plugins {
    alias(libs.plugins.weather.android.library)
}

android {
    namespace = "com.sangtq.core.network"
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.moshi)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    implementation(libs.kotlinx.serialization.json)
    implementation(project(":core:model"))
}