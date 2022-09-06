package dev.codewithdk.minimalist

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

enum class FlavorDimension {
  type
}

enum class Flavor (val dimension : FlavorDimension, val applicationIdSuffix : String? = null) {
  dev(FlavorDimension.type, ".dev"),
  prod(FlavorDimension.type)
}

fun Project.configureFlavors(
  commonExtension: CommonExtension<*, *, *, *>
) {
  commonExtension.apply {
    flavorDimensions += FlavorDimension.type.name
    productFlavors {
      Flavor.values().forEach{
        create(it.name) {
          dimension = it.dimension.name
        }
      }
    }
  }
}