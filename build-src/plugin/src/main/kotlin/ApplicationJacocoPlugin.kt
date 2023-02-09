import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import dev.dineshktech.app.starter.configureJacoco
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class ApplicationJacocoPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("org.gradle.jacoco")
        apply("com.android.application")
      }
      val extension = extensions.getByType<ApplicationAndroidComponentsExtension>()
      configureJacoco(extension)
    }
  }
}