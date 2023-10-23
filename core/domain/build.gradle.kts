import Dependencies.usingAndroidTestDependencies
import Dependencies.usingCoreKtxDependencies
import Dependencies.usingHiltDependencies
import Dependencies.usingKotlinStdLibDependencies
import Dependencies.usingTimberDependencies
import Dependencies.usingUnitTestDependencies
import Dependencies.usingSplashDependencies
import Dependencies.usingComposeDependencies
import Dependencies.usingActivityDepdendencies
import Dependencies.usingTimeDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ajouunia.core.domain"
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
    this.usingKotlinStdLibDependencies()
    this.usingCoreKtxDependencies()

    this.usingHiltDependencies()

    this.usingUnitTestDependencies()
    this.usingAndroidTestDependencies()

    this.usingTimberDependencies()
    this.usingTimeDependencies()
}

kapt {
    correctErrorTypes = true
}