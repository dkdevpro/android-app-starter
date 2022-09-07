@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("codewithdk.android.library")
    id("codewithdk.android.library.jacoco")
    kotlin("kapt")
}

dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}