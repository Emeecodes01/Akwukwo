plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    kotlin("kapt")
}


android {
    compileSdkVersion(Config.Versions.compileSdkVer)
    buildToolsVersion(Config.Versions.buildToolsVer)


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

}


dependencies {
    implementation(project(":mobile-ui"))
    player()
}