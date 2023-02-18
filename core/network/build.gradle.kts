plugins {
    id("dineshktech.android.library")
    id("dineshktech.android.library.jacoco")
    id("dineshktech.android.hilt")
    id("kotlinx-serialization")
}
dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}
