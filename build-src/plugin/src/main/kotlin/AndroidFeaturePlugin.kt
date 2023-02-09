import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeaturePlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
        apply("org.jetbrains.kotlin.kapt")
      }
      extensions.configure<LibraryExtension> {
        defaultConfig {
          testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
      }

      val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

      dependencies {
        add("implementation", project(":core:model"))
        add("implementation", project(":core:data"))
        add("implementation", project(":core:common"))

        add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
        add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
        add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
        add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
        add("implementation", libs.findLibrary("hilt.android").get())
        add("kapt", libs.findLibrary("hilt.compiler").get())
      }
    }
  }
}