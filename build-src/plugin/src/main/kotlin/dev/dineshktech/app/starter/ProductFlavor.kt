package dev.dineshktech.app.starter

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor
import org.gradle.api.Project
enum class FlavorDimension {
  type
}
enum class Flavor (val dimension : FlavorDimension, val applicationIdSuffix : String? = null) {
  dev(FlavorDimension.type, ".dev"),
  prod(FlavorDimension.type, ".prod")
}
fun Project.configureFlavors(
  commonExtension: CommonExtension<*, *, *, *>,
  flavorConfigurationBlock: ProductFlavor.(flavor: Flavor) -> Unit = {}
) {
  commonExtension.apply {
    flavorDimensions += FlavorDimension.type.name
    productFlavors {
      Flavor.values().forEach{
        create(it.name) {
          dimension = it.dimension.name
          flavorConfigurationBlock(this, it)
          if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
            if (it.applicationIdSuffix != null) {
              this.applicationIdSuffix = it.applicationIdSuffix
            }
          }
        }
      }
    }
  }
}