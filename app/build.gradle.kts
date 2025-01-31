plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.firebase.crashlytics")
}

android {
    applyDefault()

    defaultConfig {
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":feature:home"))
    implementation(project(":feature:combination"))
    implementation(project(":feature:detail"))

    Firebase.run {
        implementation(platform(PLATFORM))
        implementation(ANALYTICS_KTX)
        implementation(FIRESTORE_KTX)
        implementation(CRASHLYTICS_KTX)
    }

    Hilt.run {
        implementation(ANDROID)
        kapt(COMPILER)
    }

    implementation(Google.PLAY_CORE_KTX)
}
