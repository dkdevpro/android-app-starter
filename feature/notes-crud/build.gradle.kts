
plugins {
    id("dineshktech.android.feature")
    id("dineshktech.android.library.compose")
    id("dineshktech.android.library.jacoco")
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
}