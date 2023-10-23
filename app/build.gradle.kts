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
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ajouunia.unia_android"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = "com.ajouunia.unia_android"
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.APP_VERSION

        testInstrumentationRunner = AppConfig.ANDROID_TEST_INSTRUMENTATION_RUNNER
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(project(":core:loggingsystem"))
    implementation(project(":core:network"))
    implementation(project(":feature:splash"))
    implementation(project(":feature:onboarding"))
    implementation(project(":feature:mainroot"))

    this.usingKotlinStdLibDependencies()
    this.usingCoreKtxDependencies()

    this.usingSplashDependencies()
    this.usingActivityDepdendencies()
    this.usingComposeDependencies()

    this.usingHiltDependencies()

    this.usingUnitTestDependencies()
    this.usingAndroidTestDependencies()

    this.usingTimberDependencies()
    this.usingTimeDependencies()
}

kapt {
    correctErrorTypes = true
}