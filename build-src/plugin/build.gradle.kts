plugins {
  `kotlin-dsl`
}

group = "dev.dineshktech.app.starter.build_src"

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApplicationCompose") {
      id = "dineshktech.android.application.compose"
      implementationClass = "ApplicationComposePlugin"
    }
    register("androidApplication") {
      id = "dineshktech.android.application"
      implementationClass = "ApplicationPlugin"
    }
    register("androidApplicationJacoco") {
      id = "dineshktech.android.application.jacoco"
      implementationClass = "ApplicationJacocoPlugin"
    }
    register("androidLibraryCompose") {
      id = "dineshktech.android.library.compose"
      implementationClass = "AndroidLibraryComposePlugin"
    }
    register("androidLibrary") {
      id = "dineshktech.android.library"
      implementationClass = "AndroidLibraryPlugin"
    }
    register("androidFeature") {
      id = "dineshktech.android.feature"
      implementationClass = "AndroidFeaturePlugin"
    }
    register("androidLibraryJacoco") {
      id = "dineshktech.android.library.jacoco"
      implementationClass = "AndroidLibraryJacocoPlugin"
    }
    register("androidTest") {
      id = "dineshktech.android.test"
      implementationClass = "AndroidTestPlugin"
    }
    register("firebase-perf") {
      id = "dineshktech.firebase-perf"
      implementationClass = "FirebasePerfPlugin"
    }
  }
}
