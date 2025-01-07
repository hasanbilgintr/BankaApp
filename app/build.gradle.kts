plugins {
    alias(libs.plugins.android.application)

    id ("androidx.navigation.safeargs")//eklendi
}

android {
    namespace = "com.hasanbilgin.bankaapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hasanbilgin.bankaapp"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}
val nav_version = "2.7.7" //navigation eklendi

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.legacy.support.v4)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)


    implementation("com.squareup.retrofit2:retrofit:2.1.0")//retrofit eklendi
    implementation("com.squareup.okhttp3:okhttp:4.9.0")//retrofit eklendi
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")//retrofit eklendi


    implementation("androidx.navigation:navigation-fragment:$nav_version")//navigation eklendi
    implementation("androidx.navigation:navigation-ui:$nav_version")//navigation eklendi

    //pdf için eklendi
    //implementation ("com.github.Foysalofficial:pdf-viewer-android:6.1")//bölede kalabilir yada tıklayarak hale getirilebiliz
    implementation (libs.pdf.viewer.android)
}