import org.gradle.api.artifacts.dsl.DependencyHandler
import utils.androidTestImplementation
import utils.annotationProcessor
import utils.debugImplementation
import utils.implementation
import utils.kapt
import utils.testImplementation

object Dependencies {
    //region Kotlin
    private val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${LibVersions.KOTLIN}"
    private val coreKtx = "androidx.core:core-ktx:${LibVersions.CORE}"
    private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibVersions.COROUTINES}"
    //endregion

    //region Android
    private val splash = "androidx.core:core-splashscreen:${LibVersions.SPLASH}"
    private val activity = "androidx.activity:activity-ktx:${LibVersions.ACTIVITY}"
    private val activity_compose = "androidx.activity:activity-compose:${LibVersions.ACTIVITY}"
    private val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.LIFECYCLE}"
    //endregion

    //region Compose
    private val composeBom = "androidx.compose:compose-bom:${LibVersions.COMPOSE_BOM}"
    private val composeMaterial = "androidx.compose.material3:material3"
    private val composeTooling = "androidx.compose.ui:ui-tooling"
    private val composePreview = "androidx.compose.ui:ui-tooling-preview"
    private val composeLiveData = "androidx.compose.runtime:runtime-livedata"
    private val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${LibVersions.COMPOSE_VIEW_MODEL}"
    private val composeNavigation = "androidx.navigation:navigation-compose:${LibVersions.COMPOSE_NAVIGATION}"
    private val runtime_compose = "androidx.lifecycle:lifecycle-runtime-compose:${LibVersions.COMPOSE_NAVIGATION}"
    //endregion

    //region OkHttp
    private val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${LibVersions.OKHTTP}"
    private val okhttp = "com.squareup.okhttp3:okhttp"
    private val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor"
    //endregion

    //region Retrofit
    private val retrofit = "com.squareup.retrofit2:retrofit:${LibVersions.RETROFIT}"
    private val gsonConverter = "com.squareup.retrofit2:converter-gson:${LibVersions.RETROFIT}"

    //endregion

    //region Room
    private val room = "androidx.room:room-runtime:${LibVersions.ROOM}"
    private val roomKtx = "androidx.room:room-ktx:${LibVersions.ROOM}"
    private val roomCompiler = "androidx.room:room-compiler:${LibVersions.ROOM}"
    private val roomTesting = "androidx.room:room-testing:${LibVersions.ROOM}"
    //endregion

    //region DataStore
    private val datastore = "androidx.datastore:datastore-preferences:${LibVersions.DATASTORE}"
    //endregion

    //region Hilt
    private val hilt = "com.google.dagger:hilt-android:${LibVersions.HILT}"
    private val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    private val hiltCompiler = "com.google.dagger:hilt-android-compiler:${LibVersions.HILT}"
    //endregion

    //region Test
    private val junit = "junit:junit:${LibVersions.JUNIT}"

    // android test
    private val androidJunit = "androidx.test.ext:junit:${LibVersions.ANDROID_JUNIT}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${LibVersions.ESPRESSO_CORE}"
    //endregion

    //region Logger
    private val timber = "com.jakewharton.timber:timber:${LibVersions.TIMBER}"
    //endregion

    fun DependencyHandler.usingActivityDepdendencies() {
        implementation(activity)
        implementation(activity_compose)
    }

    fun DependencyHandler.usingKotlinStdLibDependencies() {
        implementation(kotlinStdLib)
    }


    fun DependencyHandler.usingCoroutinesDependencies() {
        implementation(coroutines)
    }

    fun DependencyHandler.usingCoreKtxDependencies() {
        implementation(coreKtx)
    }

    fun DependencyHandler.usingSplashDependencies() {
        implementation(splash)
    }

    fun DependencyHandler.usingComposeDependencies() {
        implementation(platform(composeBom))
        implementation(composeMaterial)
        debugImplementation(composeTooling)
        implementation(composePreview)
        implementation(composeLiveData)
        implementation(composeViewModel)
        implementation(composeNavigation)
        implementation(runtime_compose)
    }

    fun DependencyHandler.usingViewModelDependencies() {
        implementation(viewModelKtx)
    }

    fun DependencyHandler.usingOkHttpDependencies() {
        implementation(platform(okhttpBom))
        implementation(okhttp)
        implementation(okhttpInterceptor)
    }

    fun DependencyHandler.usingRetrofitDependencies() {
        implementation(retrofit)
        implementation(gsonConverter)
    }

    fun DependencyHandler.usingRoomDependencies() {
        kapt(roomCompiler)
        annotationProcessor(roomCompiler)
        implementation(room)
        implementation(roomKtx)
        testImplementation(roomTesting)
    }

    fun DependencyHandler.usingDataStoreDependencies() {
        implementation(datastore)
    }

    fun DependencyHandler.usingHiltDependencies() {
        kapt(hiltCompiler)
        implementation(hilt)
        implementation(hiltCompose)
    }

    fun DependencyHandler.usingUnitTestDependencies() {
        testImplementation(junit)
    }

    fun DependencyHandler.usingAndroidTestDependencies() {
        androidTestImplementation(androidJunit)
        androidTestImplementation(espressoCore)
    }

    fun DependencyHandler.usingTimberDependencies() {
        implementation(timber)
    }


}