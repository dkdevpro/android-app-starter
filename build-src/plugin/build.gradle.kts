plugins {
  `kotlin-dsl`
}

group = "dev.codewithdk.minimalist.build_src"

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApplicationCompose") {
      id = "codewithdk.android.application.compose"
      implementationClass = "ApplicationComposePlugin"
    }
    register("androidApplication") {
      id = "codewithdk.android.application"
      implementationClass = "ApplicationPlugin"
    }
    register("androidApplicationJacoco") {
      id = "codewithdk.android.application.jacoco"
      implementationClass = "ApplicationJacocoPlugin"
    }
    register("androidLibraryCompose") {
      id = "codewithdk.android.library.compose"
      implementationClass = "AndroidLibraryComposePlugin"
    }
    register("androidLibrary") {
      id = "codewithdk.android.library"
      implementationClass = "AndroidLibraryPlugin"
    }
    register("androidFeature") {
      id = "codewithdk.android.feature"
      implementationClass = "AndroidFeaturePlugin"
    }
    register("androidLibraryJacoco") {
      id = "codewithdk.android.library.jacoco"
      implementationClass = "AndroidLibraryJacocoPlugin"
    }
    register("androidTest") {
      id = "codewithdk.android.test"
      implementationClass = "AndroidTestPlugin"
    }
    register("firebase-perf") {
      id = "codewithdk.firebase-perf"
      implementationClass = "FirebasePerfPlugin"
    }
  }
}
