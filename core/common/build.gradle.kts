plugins {
    id("dineshktech.android.library")
    id("dineshktech.android.library.jacoco")
    id("dineshktech.android.hilt")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}