
plugins {
    id("codewithdk.android.library")
    id("codewithdk.android.feature")
    id("codewithdk.android.library.compose")
    id("codewithdk.android.library.jacoco")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.kotlinx.datetime)
}
