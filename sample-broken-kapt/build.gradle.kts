import com.ibotta.gradle.aop.AopWeaveExtension

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id(Plugin.PLUGIN_ID) version Plugin.VERSION apply false
}

apply(plugin = Plugin.PLUGIN_ID)

android {
    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        applicationId = "com.ibotta.gradle.aop.brokenkapt"
        versionCode = SampleAppCommon.APP_VERSION_CODE
        versionName = SampleAppCommon.APP_VERSION_NAME
    }

    buildTypes {
        getByName("release") {
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

}

kapt {
    includeCompileClasspath = false
    javacOptions {
        option("-Xmaxerrs", 10000)
    }
}

configure<AopWeaveExtension> {
    filter = SampleAppCommon.FILTER
}

dependencies {
    implementation(kotlin("stdlib-jdk7"))
    implementation("androidx.core:core-ktx:1.3.2")
    implementation(SupportLibs.ANDROIDX_APPCOMPAT)
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation(Dependencies.ASPECT_J_RUNTIME)
    kapt("com.google.dagger:dagger-compiler:2.25.2")

    testImplementation(platform(Dependencies.JUNIT_BOM))
    testImplementation(Dependencies.JUNIT_JUPITER)
    testImplementation(Dependencies.MOCKITO)
    testImplementation(Dependencies.MOCKK)
}




