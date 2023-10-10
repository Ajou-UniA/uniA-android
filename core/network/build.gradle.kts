import Dependencies.usingHiltDependencies
import Dependencies.usingOkHttpDependencies
import Dependencies.usingRetrofitDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ajouunia.core.network"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK

        testInstrumentationRunner = AppConfig.ANDROID_TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles(AppConfig.CONSUMER_PROGUARD_RULES)
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
        sourceCompatibility = AppConfig.SOURCE_COMPATIBILITY
        targetCompatibility = AppConfig.TARGET_COMPATIBILITY
    }
    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

dependencies {
    usingHiltDependencies()
    usingOkHttpDependencies()
    usingRetrofitDependencies()
}

kapt {
    correctErrorTypes = true
}