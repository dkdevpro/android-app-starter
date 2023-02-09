import dev.dineshktech.app.starter.Flavor
import dev.dineshktech.app.starter.FlavorDimension

plugins {
  id("dineshktech.android.application")
  id("dineshktech.android.application.compose")
  id("dineshktech.android.application.jacoco")
  kotlin("kapt")
  id("jacoco")
  id("dagger.hilt.android.plugin")
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

  androidTestImplementation(libs.androidx.navigation.testing)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.window.manager)
  implementation(libs.androidx.profileinstaller)
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  kaptAndroidTest(libs.hilt.compiler)

  // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
  configurations.configureEach {
    resolutionStrategy {
      force(libs.junit4)
      // Temporary workaround for https://issuetracker.google.com/174733673
      force("org.objenesis:objenesis:2.6")
    }
  }
}
dependencies {

  androidTestImplementation(libs.androidx.navigation.testing)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.window.manager)
  implementation(libs.androidx.profileinstaller)
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  kaptAndroidTest(libs.hilt.compiler)

  // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
  configurations.configureEach {
    resolutionStrategy {
      force(libs.junit4)
      // Temporary workaround for https://issuetracker.google.com/174733673
      force("org.objenesis:objenesis:2.6")
    }
  }
}