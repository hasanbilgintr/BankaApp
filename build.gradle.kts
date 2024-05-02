

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins { alias(libs.plugins.androidApplication) apply false }


buildscript {
    repositories {
        google()//nav_version eklendi

    }

    dependencies {
        var nav_version = "2.7.7"//eklendi
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")//eklendi
    }

}


