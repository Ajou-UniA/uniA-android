import Dependencies.usingAndroidTestDependencies
import Dependencies.usingCoreKtxDependencies
import Dependencies.usingCoroutinesDependencies
import Dependencies.usingDataStoreDependencies
import Dependencies.usingHiltDependencies
import Dependencies.usingKotlinStdLibDependencies
import Dependencies.usingOkHttpDependencies
import Dependencies.usingRetrofitDependencies
import Dependencies.usingRoomDependencies
import Dependencies.usingTimberDependencies
import Dependencies.usingUnitTestDependencies
import Dependencies.usingTimeDependencies

plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.library")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ajouunia.core.data"
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
    implementation(project(":core:domain"))

    usingKotlinStdLibDependencies()
    usingCoroutinesDependencies()
    usingCoreKtxDependencies()
    usingOkHttpDependencies()
    usingRetrofitDependencies()
    usingRoomDependencies()
    usingDataStoreDependencies()
    usingHiltDependencies()
    usingUnitTestDependencies()
    usingAndroidTestDependencies()
    usingTimberDependencies()
    usingTimeDependencies()
}

kapt {
    correctErrorTypes = true
}