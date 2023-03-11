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
        apply("dineshktech.android.library")
        apply("dineshktech.android.hilt")
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
        add("implementation", project(":core:domain"))

        add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
        add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
        add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
        add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())

        add("api", libs.findLibrary("androidx.compose.foundation").get())
        add("api", libs.findLibrary("androidx.compose.foundation.layout").get())
        add("api", libs.findLibrary("androidx.compose.material.iconsExtended").get())
        add("api", libs.findLibrary("androidx.compose.material3").get())
        add("debugApi", libs.findLibrary("androidx.compose.ui.tooling").get())
        add("api", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
        add("api", libs.findLibrary("androidx.compose.ui.util").get())
        add("api", libs.findLibrary("androidx.compose.runtime").get())
      }
    }
  }
}