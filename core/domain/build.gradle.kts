plugins {
    id("dineshktech.android.library")
    id("dineshktech.android.library.jacoco")
    id("dineshktech.android.hilt")
}


dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
}