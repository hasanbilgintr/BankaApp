pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        //eklendi pdf için
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //pdf için eklendi
        maven {
            url = uri("https://www.jitpack.io" )
        }
        //eklendi pdf için
        jcenter()
    }
}

rootProject.name = "BankaApp"
include(":app")
