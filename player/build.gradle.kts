import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}


android {
    compileSdkVersion(Config.Versions.compileSdkVer)
    buildToolsVersion(Config.Versions.buildToolsVer)

    dataBinding { isEnabled = true }

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Versions.minSdk)
        targetSdkVersion(Config.Versions.targetSdk)
        versionCode = Config.Versions.versionCode
        versionName = Config.Versions.versionName

        testInstrumentationRunner = Config.Android.testRunner
    }


    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-logic.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType <KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

}


dependencies {
    implementation(project(":mobile-ui"))
    player()
}