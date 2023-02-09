
plugins {
    id("dineshktech.android.library")
    id("dineshktech.android.feature")
    id("dineshktech.android.library.compose")
    id("dineshktech.android.library.jacoco")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.kotlinx.datetime)
}
