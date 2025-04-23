import com.android.build.api.dsl.ApplicationExtension
import com.sangtq.convention.configureKotlinAndroid
import com.sangtq.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("weather.android.hilt")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
            }


            dependencies {
                add("implementation", project(":core:model"))
                add("implementation", project(":core:domain"))


                add("implementation", libs.findLibrary("androidx-core-ktx").get())
                add("implementation", libs.findLibrary("androidx-appcompat").get())
                add("implementation", libs.findLibrary("material").get())
                add("implementation", libs.findLibrary("androidx-activity").get())
                add("implementation", libs.findLibrary("androidx-constraintlayout").get())
                add("implementation", libs.findLibrary("androidx-databinding-runtime").get())
                add("implementation", libs.findLibrary("androidx-fragment-ktx").get())

                add("androidTestImplementation", kotlin("test"))
                add("testImplementation", kotlin("test"))
            }
        }
    }
}