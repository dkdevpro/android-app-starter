import dev.dineshktech.app.starter.Flavor
import dev.dineshktech.app.starter.FlavorDimension
plugins {
  id("dineshktech.android.application")
  id("dineshktech.android.application.compose")
  id("dineshktech.android.application.jacoco")
  id("dineshktech.android.hilt")
  id("dineshktech.firebase-perf")
}

android {

  defaultConfig {
    applicationId = "dev.dineshktech.app.starter"
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {

    val debug by getting {
      applicationIdSuffix = ".dev"
    }

    val release by getting {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  flavorDimensions += FlavorDimension.type.name
  productFlavors {
    Flavor.values().forEach {
      create(it.name) {
        dimension = it.dimension.name
        if (it.applicationIdSuffix != null) {
          applicationIdSuffix = it.applicationIdSuffix
        }
      }
    }
  }

  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
  testOptions {
    unitTests {
      isIncludeAndroidResources = true
    }
  }
}


dependencies {

  //Domain module dependencies
  implementation(project(":core:common"))
  implementation(project(":core:data"))
  implementation(project(":core:model"))
  implementation(project(":feature:notes-favorite"))
  implementation(project(":feature:notes-crud"))

  androidTestImplementation(libs.androidx.navigation.testing)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.runtime)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.window.manager)
  implementation(libs.accompanist.systemuicontroller)
  implementation(libs.androidx.compose.material3.windowSizeClass)

  // Compose navigation
  implementation(libs.androidx.hilt.navigation.compose)
  implementation(libs.androidx.navigation.compose)
  implementation(libs.androidx.hilt.navigation.compose)
  androidTestImplementation(libs.androidx.navigation.testing)

  // Material3
  api(libs.androidx.compose.material.iconsExtended)
  api(libs.androidx.compose.material3)

  implementation(libs.androidx.profileinstaller)
}
