plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.tiagomdosantos.rickyandmorty"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tiagomdosantos.rickyandmorty"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    // UTILS
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.compiler)

    // LIFECYCLE
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // UI
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.constraintlayout)

    // MATERIAL3
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.window.size)

    // LOTTIE
    implementation(libs.android.lottie) {
        exclude(group = "com.intellij", module = "annotations")
    }

    // DATA STORE
    implementation(libs.androidx.dataStore.core) {
        exclude(group = "com.intellij", module = "annotations")
    }

    // HILT
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.compose) {
        exclude(group = "com.intellij", module = "annotations")
    }
    kapt(libs.androidx.hilt.compiler)

    // PAGING
    implementation(libs.androidx.paging.runtime) {
        exclude(group = "com.intellij", module = "annotations")
    }
    implementation(libs.androidx.paging.compose) {
        exclude(group = "com.intellij", module = "annotations")
    }

    // MOSHI
    implementation(libs.moshi.kotlin){
        exclude(group = "com.intellij", module = "annotations")
    }
    kapt(libs.moshi.codegen)

    // RETROFIT
    implementation(libs.okhttp.okhttp) {
        exclude(group = "com.intellij", module = "annotations")
    }
    implementation(libs.okhttp.loggingInterceptor) {
        exclude(group = "com.intellij", module = "annotations")
    }
    implementation(libs.retrofit.retrofit) {
        exclude(group = "com.intellij", module = "annotations")
    }
    implementation(libs.retrofit.moshi.converter) {
        exclude(group = "com.intellij", module = "annotations")
    }

    // COIL
    implementation(libs.coil) {
        exclude(group = "com.intellij", module = "annotations")
    }
    implementation(libs.coil.compose) {
        exclude(group = "com.intellij", module = "annotations")
    }

    // TESTING
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // ADAPTIVE NAVIGATION
    implementation(libs.androidx.compose.material3.adaptive.navigation.suite)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
}