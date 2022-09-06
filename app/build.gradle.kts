import dev.codewithdk.minimalist.Flavor
import dev.codewithdk.minimalist.FlavorDimension

plugins {
  id("codewithdk.android.application")
  id("codewithdk.android.application.compose")
  id("codewithdk.android.application.jacoco")
  kotlin("kapt")
  id("jacoco")
  id("dagger.hilt.android.plugin")
  id("codewithdk.firebase-perf")
}

android {

  defaultConfig {
    applicationId = "dev.codewithdk.minimalist"
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

//  implementation(project(":core-ui"))
//  implementation(project(":core-designsystem"))
//  implementation(project(":core-navigation"))
//
//  implementation(project(":sync"))
//
//  androidTestImplementation(project(":core-testing"))
//  androidTestImplementation(project(":core-datastore-test"))
//  androidTestImplementation(project(":core-data-test"))
//  androidTestImplementation(project(":core-network"))
  androidTestImplementation(libs.androidx.navigation.testing)
  debugImplementation(libs.androidx.compose.ui.testManifest)

  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.core.splashscreen)
  implementation(libs.androidx.compose.material3.windowSizeClass)
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
  //implementation(project(":core-ui"))
  //implementation(project(":core-designsystem"))
  //implementation(project(":core-navigation"))

  //androidTestImplementation(project(":core-testing"))
  //androidTestImplementation(project(":core-datastore-test"))
  //androidTestImplementation(project(":core-data-test"))
  //androidTestImplementation(project(":core-network"))
  androidTestImplementation(libs.androidx.navigation.testing)
  debugImplementation(libs.androidx.compose.ui.testManifest)

  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.core.splashscreen)
  implementation(libs.androidx.compose.material3.windowSizeClass)
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