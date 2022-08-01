plugins {
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.kc.kmmdemo.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding =true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    //Glide - Image loading
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation ("jp.wasabeef:glide-transformations:4.3.0") //Vignette
    implementation ("jp.co.cyberagent.android:gpuimage:2.1.0")

    // Architectural Components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
}