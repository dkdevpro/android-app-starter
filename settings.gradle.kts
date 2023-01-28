pluginManagement {
  includeBuild("build-src")
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "android-boilerplate-latest"
include(":app")
include(":core:navigation")
include(":feature:add-notes")
//include(":feature-edit-notes")
//include(":feature-notes-list")
include(":core:common")
include(":core:data")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:ui")

