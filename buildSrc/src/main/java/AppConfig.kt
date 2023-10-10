object AppConfig {
    val MIN_SDK = 24
    val COMPILE_SDK = 34
    val TARGET_SDK = 34

    private val MAJOR_VERSION = "1"
    private val MINOR_VERSION = "0"
    private val PATCH_VERSION = "0"

    val APP_VERSION = "$MAJOR_VERSION.$MINOR_VERSION.$PATCH_VERSION"
    val VERSION_CODE = 1

    val ANDROID_TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    val CONSUMER_PROGUARD_RULES = "consumer-rules.pro"

    val SOURCE_COMPATIBILITY = org.gradle.api.JavaVersion.VERSION_17
    val TARGET_COMPATIBILITY = org.gradle.api.JavaVersion.VERSION_17

    val JVM_TARGET = "17"
}