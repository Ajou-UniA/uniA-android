import Dependencies.usingAndroidTestDependencies
import Dependencies.usingCoreKtxDependencies
import Dependencies.usingHiltDependencies
import Dependencies.usingKotlinStdLibDependencies
import Dependencies.usingTimberDependencies
import Dependencies.usingUnitTestDependencies
import Dependencies.usingSplashDependencies
import Dependencies.usingComposeDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ajouunia.feature.onboarding"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation(project(":core:designsystem"))

    this.usingKotlinStdLibDependencies()
    this.usingCoreKtxDependencies()

    this.usingSplashDependencies()
    this.usingComposeDependencies()

    this.usingHiltDependencies()

    this.usingUnitTestDependencies()
    this.usingAndroidTestDependencies()

    this.usingTimberDependencies()
}