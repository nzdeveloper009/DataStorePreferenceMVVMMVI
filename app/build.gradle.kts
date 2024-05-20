plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.syedzada.android.datastorepreferenceemvvmmviexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.syedzada.android.datastorepreferenceemvvmmviexample"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // SDP layout size && SSP Text sizes
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    // Koin for dependency injection
    implementation(libs.koin.android)

    // Preferences DataStore
    implementation(libs.androidx.datastore.preferences)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //Android KTX is a set of Kotlin extensions to help your write concise and idiomatic code.
    // by viewModel extension is not available by default for a new android project and should be added using Android KTX,
    implementation(libs.androidx.activity.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
}